import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {NEWS_CATEGORIES} from '../constants';
import {Country, GetNewsCommand, SearchCriteria} from '../models';
import {NewsService} from '../news.service';

@Component({
  selector: 'app-news-criteria',
  templateUrl: './news-criteria.component.html',
  styleUrls: ['./news-criteria.component.css']
})
export class NewsCriteriaComponent implements OnInit {

	countries: Country[] = []
	categories = NEWS_CATEGORIES
	flag: string | undefined = ""

	form!: FormGroup

	constructor(private fb: FormBuilder , private newsSvc: NewsService) { }

	ngOnInit(): void {

		this.newsSvc.getCountries()
			.then(result => this.countries = result)

		this.form = this.fb.group({
			code: this.fb.control('', [ Validators.required ]),
			category: this.fb.control('', [ Validators.required ])
		})
	}

	onCountryChange(selectElem: any) {
		const code = selectElem.target.value
		const country = this.countries.find(c => c.code == code)
		this.flag = country?.flag
	}

	performSearch() {
		const criteria = this.form.value as SearchCriteria
		console.info('>>> criteria: ', criteria)

    this.newsSvc.execute.next({ criteria } as GetNewsCommand )
	}

}
