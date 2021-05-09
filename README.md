# IBrain-Task
I have created dynamic web application inside that i have use servlet, html, bootstrap, jdbc concepts, mysql database
using servlet i have perform database query.
html used for design UI.
bootstrap for style and design.
mysql used for setting up database.

when you execute project it firstly run index.html page that means home page of our application.
all html file contain front end code and backend code written inside servlet.

-> WebContent folder contain .html files
-> src folder contain .java files.
-> build/classes folder contain all .class file of .java files

index.html file is a homepage of this task that contain UI -
![Screenshot (742)](https://user-images.githubusercontent.com/59825872/117578425-efbf9980-b10b-11eb-9033-c1591def7e3f.png)


**byClinicId.html, byMonth.html, byYear.html that file contain the first task **
when you click on byClinicId.html it count appointments clinic wise.
![Screenshot (743)](https://user-images.githubusercontent.com/59825872/117578519-6492d380-b10c-11eb-8907-00c2f94a3119.png)
when you click on byMonth.html then it count appointments month wise.
![Screenshot (744)](https://user-images.githubusercontent.com/59825872/117578534-73798600-b10c-11eb-97f7-8448fc61a780.png)
when you click on byYear.html then it count appointments year wise.
![Screenshot (745)](https://user-images.githubusercontent.com/59825872/117578542-7eccb180-b10c-11eb-816c-7328a4f58b82.png)

patient.html contain task 2 details
it shows a list of patients with patient details who do not have appointments in the future. Display a table on UI.
![Screenshot (746)](https://user-images.githubusercontent.com/59825872/117578844-fa7b2e00-b10d-11eb-90a1-30964b1a529c.png)


calAge.html contain task3 details
it Calculate the age of the patient from birthdate and update it into the table. Update patientagegroup column based on a following condition - if age is less than 18 then Minor and other Adult.

tabFormat.html contain task4 details
it Display on UI in tabular format. Total production, Payments, Production Adjustments, Collection Adjustments by clinic name by Provider name by year by month.

delApp.html contain task 5 details
it Add functionality to delete appointment having amount less than 50
![Screenshot (747)](https://user-images.githubusercontent.com/59825872/117578861-12eb4880-b10e-11eb-9ef7-d44997615fe3.png)

