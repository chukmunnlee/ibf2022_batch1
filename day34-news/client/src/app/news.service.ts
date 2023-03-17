import {HttpClient, HttpParams} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {firstValueFrom, map, Subject, tap} from "rxjs";
import {COUNTRY_API, COUNTRY_CODES, NEWS_API} from "./constants";
import {Article, Country, GetNewsCommand, SearchCriteria} from "./models";

@Injectable()
export class NewsService {

	countries: Country[] = []

  execute = new Subject<GetNewsCommand>()
  onNewArticles = new Subject<Promise<Article[]>>()

	constructor(private http: HttpClient) {
    this.execute.subscribe(command => {
      this.onNewArticles.next(
        this.getNews(command.criteria)
      )
    })
  }

  canShare(): boolean {
    return !!navigator['share']
  }

  share(text: string) {
    return navigator.share({
      title: "News New",
      text: text
    })
  }

  getNews(criteria: SearchCriteria): Promise<Article[]> {
    console.info('>> criteria: ', criteria)
    const code = criteria.code
    const category = criteria.category
    const params = new HttpParams()
        //.set('country', code)
        //.set('category', category)
        .set('pageSize', 10)
    return firstValueFrom(
      this.http.get<Article[]>(`${NEWS_API}/${code}/${category}`, { params })
    ).then(result => {
      console.info('>>> result: ', result)
      this.onNewArticles.next(Promise.resolve(result))
      return result
    })
  }

	getCountries(): Promise<Country[]> {

		if (!!this.countries.length)
			return Promise.resolve(this.countries)

		const params = new HttpParams()
					.set('codes', COUNTRY_CODES)

		return firstValueFrom(
			this.http.get<Country[]>(COUNTRY_API, { params })
		).then(result => {
			this.countries = result.map(
				(c: any) => (
					{
						name: c.name.official,
						code: c.cca2.toLowerCase(),
						flag: c.flags.png
					} as Country
				)
			)
			this.countries.sort((a, b) => a.name > b.name? 1: -1)
			return this.countries
		})
	}

}
