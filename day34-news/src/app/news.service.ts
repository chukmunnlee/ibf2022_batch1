import {HttpClient, HttpParams} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {firstValueFrom, map, Subject} from "rxjs";
import {COUNTRY_API, COUNTRY_CODES, NEWS_API} from "./constants";
import {Article, Country, GetNewsCommand, SearchCriteria} from "./models";

const API_KEY = "__YOUR_NEWS_API_KEY_HERE__"

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

  getNews(criteria: SearchCriteria): Promise<Article[]> {
    console.info('>> criteria: ', criteria)
    const params = new HttpParams()
        .set('country', criteria.code)
        .set('category', criteria.category)
        .set('pageSize', 10)
        .set('apiKey', API_KEY)
    return firstValueFrom(
      this.http.get<Article[]>(NEWS_API, { params })
        .pipe(
          map((data: any) => data.articles as any[]),
          map((data: any[]) => {
            return data.map(a => {
              return {
                author: a.author,
                title: a.title,
                description: a.description,
              } as Article
            })
          })
        )
    ).then(result => {
      console.info('>>> result: ', result)
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
