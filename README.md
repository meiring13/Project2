# Project2
1. I first looked at the Driver class and saw what classes needed to be created and also the methods within those classes. Based off my first commit, I started with PosAvg first and decided to out my read method in there because I knew that I would be reading from the Mesonet.txt file to calculate the position Avg of the passed in stationID. Similar to last project, I stored all the read-in stations into an array and expanded the array when I needed to. Also in my first commit, I started working on the indexOfStation method. I passed in the private variable stID and set it equal to a String index. I looped through the stations and whenever the index station was found, it was returned. Lastly in PosAvg, I created a toString method because I noticed that the driver was printing PosAvg object and the project description had a desired output for PosAvg.

2. Next, I started working on LetterAvg because of the similarity to PosAvg, I used the same read-in method and try and catch statement as used in PosAvg. This time instead of trying to find the index of the station I wanted to count the amount of times the statiodID had the same letterAvg as all stations in the array. By looping through the stations and checking to see if the first letter (charAt.index of 0) was equal to the letter avg, you can increment the variable for how many actually have the first letter.
Then printing them out on a newline for the user in the toString(). 

3.Lastly, I started working on the MesoInherit class. I first went to the driver and saw what needed to be printed out exactly. I noticed that calavg was printing locations of an array so I knew that I needed to store my ascii values in an array of size 3. I wanted to make a variable that added up the the total amount so then I could divide by 4 to get the average. Seeing the print out for floor, ceiling, and average meant that I had to use Math.ceil, Math.floor, etc. With the letterAverage method I created an auto-generated method from the driver and noticed I'd be returning a char, specifically the letterAvg of the ascii average.