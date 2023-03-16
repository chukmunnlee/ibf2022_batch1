import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { Weather } from './models';
import { WeatherService } from './weather.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  form!: FormGroup
  weather: Weather[] = []
  weather$!: Observable<Weather[]>

  constructor(private fb: FormBuilder, private weatherSvc: WeatherService) { }

  ngOnInit(): void {
    this.form = this.fb.group({
      city: this.fb.control('', [ Validators.required ])
    })
  }

  getWeather() {
    const city = this.form.value.city
    console.info('>>> city: ', city)
    // this.weatherSvc.getWeather(city)
    //   .then(result => {
    //     this.weather = result
    //     console.info('>>> weather: ', this.weather)
    //     this.form.reset()
    //   })
    //   .catch(error => {
    //     console.info('>>> error: ', error)
    //   })

    //this.weather$ = this.weatherSvc.getWeatherAsObservable(city)
    this.weatherSvc.getWeather(city)

  }

}
