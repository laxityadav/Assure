Problem Statement: - To design an embedded system and app  with which we will be able to Test corona virus symptoms at home , and we will be able to locate areas and no. of cases infected with COVID-19 on the Map.

Description:  - As we are facing an epidemic in the form of corona virus .It is important to increase the amount of testing facility so that those who are infected and are scared of getting out of houses don’t end up transmitting corona to their whole family. It can also help us get a perfect amount of people who need to test for corona virus and have all the symptoms related to that, this data will help us anticipate the steps to be taken in order to protect lives from COVID-19.

Hardware:-
(Embedded system)
1.	It contains a DHT11 sensor that is temperature humidity sensor to measure the body temperature of the person taking the test. That is the first symptom of COVID-19, a person suffering from fever for more than 3 days that too above a temperature of 101 degrees Fahrenheit or 38.333 degrees Celsius.
2.	The next symptom is the breathing rate .As a corona virus patient experiences shortness of breath its breathing rate is quite high than normal that is above 18 it can even reach to 25 breaths per minute. Normal breathing rate is 8-10 breaths per minute. It is measured with the help of Accelerometer sensor that detects the position change in abdomen which will be divided by 2 for counting the breathing rate per minute.

Software:-
(App)
The app consists of two main aspects. The first is the detection of probability of COVID-19 with the help of its symptoms and storing the personal details of the person taking the test including his name, address, phone no. and result in the database. The second aspect is to locate all the areas and number of cases infected with COVID-19 on the Map. Which is done by providing a portal to all the doctors so that they can feed in the address of any new COVID-19 patient and that will be marked on the Map automatically. This would help the common people to avoid going to such areas and also help the healthcare workers and government officials to identify and manage the cases accordingly.

The app will first of all ask whether you want to check the corona patients nearby or take the initiative to test for COVID-19.If you select testing for COVID-19 then it will ask for the initial data of the person taking the test like Name, Email Id, phone no. and address. The symptoms that will be asked through the app are:-
1. High Body Temperature: - which will be measured by the embedded system.
2. Dry cough/ wet cough
3. Shortness of Breath: - Breathing rate will be measured by the embedded system.
4. Tiredness (sometimes)
5. Aches and pains (sometimes)
6. Headaches (sometimes)
7. Sore throat (sometimes)
After this it will give the result whether that person’s chance of being affected by COVID-19 is high or it’s just a common cold.
And at the end the app will store all the data with the help of DBMS; we can maintain the data of each and every patient separately and can share it with the government for a better treatment of COVID-19. 
