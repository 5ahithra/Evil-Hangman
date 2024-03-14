Lab created for Computer Science 3 class. Objective of lab is to focus on using the built in Java Map and Set collections.In a normal game of hangman, the computer picks a word that the user is supposed to guess. The user then
guesses individual lettersuntilthewordis fullydiscovered. If youaren’tfamiliarwiththegeneralrulesof
the game of hangman, review its Wikipedia page: http://en.wikipedia.org/wiki/Hangman_(game)
In our (EVIL!) game of hangman, the computer delays picking a word until it is forced to. As a result,
the computeris always considering a set ofwords that could be the answer. In orderto fooltheuserinto
thinkingitisplayingfairly,thecomputeronlyconsiderswordswiththesameletterpattern.Example Game of Evil Hangman
>> Welcome to the hangman game.
>> What length word do you want to use? 4
>> How many wrong answers allowed? 7
>> guesses : 7
>> guessed : []
>> current : ----
>> Your guess? e
>> Sorry, there are no e's
>> guesses : 6
>> guessed : [e]
>> current : ----
>> Your guess? o
>> Yes, there are 2 o's
>> guesses : 6
>> guessed : [e, o]
>> current : -oo-
>> Your guess? d
>> Sorry, there are no d's
>> guesses : 5
>> guessed : [d, e, o]
>> current : -oo-
>> Your guess? c
>> Yes, there is one c
>> guesses : 5
>> guessed : [c, d, e, o]
>> current : coo-
>> Your guess? l
>> Yes, there is one l
>> answer = cool
>> You beat me
>>
>> 
Lab finished on October 18th, 2023
