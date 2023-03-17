import {Injector} from "@angular/core";
import {Scene} from "phaser";
import {GameService} from "../game.service";
import {Globals} from "../globals";

export class MainScene extends Scene {

	fish!: Phaser.GameObjects.Image
	cursor!: Phaser.Types.Input.Keyboard.CursorKeys

	injector!: Injector
	gameSvc!: GameService

	constructor() {
		super('main')
		this.injector = Globals.injector
	}

	preload() {
		this.load.image('fish', '/assets/blockfish.png')
		this.cursor = this.input.keyboard.createCursorKeys()
	}
	create() {
		this.fish = this.add.image(250, 250, 'fish')
		this.fish.scaleX = .3
		this.fish.scaleY = .3
	}

	override update() {
		if (this.cursor.down.isDown)
			this.fish.y += 4

		if (this.cursor.up.isDown)
			this.fish.y -= 4;

		if (this.cursor.left.isDown)
			this.fish.x -= 4

		if (this.cursor.right.isDown)
			this.fish.x += 4
	}

}
