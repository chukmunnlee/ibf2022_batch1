import { Component, OnInit } from '@angular/core';
import {Title} from '@angular/platform-browser';
import {Game} from 'phaser';
import {MainScene} from './scenes/main.scene';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

	game!: Game

	constructor(private title: Title) { }

	ngOnInit(): void {
		this.title.setTitle('My First Game')
		this.game = new Game({
			width: 500,
			height: 500,
			parent: 'game',
			scene: [ MainScene ],
			physics: {
				default: 'arcade'
			}
		})
		
	}
}
