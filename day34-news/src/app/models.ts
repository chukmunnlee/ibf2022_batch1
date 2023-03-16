export interface Country {
	name: string
	code: string
	flag: string
}

export interface SearchCriteria {
	code: string
	category: string
}

export interface Command { }
export interface GetNewsCommand extends Command {
  criteria: SearchCriteria
}

export interface Article {
  author: string
  title: string
  description: string
}
