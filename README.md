#Task
The Task

We have a platform where doctors can register their patients through a mobile or web portal. For this to work we need to build backend APIs to achieve task like:

Adding a doctor & their speciality
Adding a patient & it’s symptom
Suggesting the doctor based on patient’s symptom

# Doctor’s entity

In our database we will have the doctor's name, city, email, phone number, and speciality.

City can have 3 values only i.e. Delhi, Noida, Faridabad
Speciality can have 4 values i.e. Orthopedic, Gynecology, Dermatology, ENT specialist
A doctor can be added or removed from the platform.


# Patient’s entity

In our database we will have the patient's name, city, email, phone number, and symptom.

City can have any value
Symptom can have the following values only
Arthritis, Back Pain, Tissue injuries (comes under Orthopedic speciality)
Dysmenorrhea (comes under Gynecology speciality)
Skin infection, skin burn (comes under Dermatology speciality)
Ear pain (comes under ENT speciality)
A patient can be added or removed from the platform.


Following fields should have the mentioned validations at the backend:

Name (should be at least 3 characters)
City (should be at max 20 characters)
Email (should be a valid email address)
Phone number (should be at least 10 number)

# Suggesting Doctors

There will be another API that will accept patient ID, and suggest the doctors based on the patient location and the symptom.

E.g. 1: If the patient ID that we received as request param in this API, that patient has Arthritis as a symptom then all the doctors of that location who is an Orthopedic will be sent as the response, since Arthritis comes under Orthopedic speciality.


Important Note: This suggesting doctor API  is the evaluating API where the logic needs to be working. The suggested doctor in the API should be based on the symptom of the patient that links to the doctor's speciality. E.g. 2: If a patient has Eye pain then only an ENT specialist doctor should be suggested.

Edge-Case 1: If there isn’t any doctor on that location (i.e. outside Delhi, Noida, Faridabad), the response should be “We are still waiting to expand to your location”

Edge-Case 2: If there isn’t any doctor for that symptom on that location, the response should be “There isn’t any doctor present at your location for your symptom”

# TheLatticeAssignment
This is a platform where we can mange the doctors and the patients. features: create doctor | login doctor | Get Doctor by email | Delete doctor by Email | Get all Doctors || create Patient | Login Patient | Get By Email | Delete by Email | Get all Patients | Get the suggestions for patient
![doctor entity](https://github.com/pradeepsingroul/TheLatticeAssignment/assets/104360276/66a63259-73fe-4936-aa86-c18b030d7704)
![Patient Entity](https://github.com/pradeepsingroul/TheLatticeAssignment/assets/104360276/94976d1e-0b63-4d23-a2b0-cbf58a8696e3)
![loginDto](https://github.com/pradeepsingroul/TheLatticeAssignment/assets/104360276/a5f34aa6-b811-4727-ab38-e57d30dc3f5c)
![DoctorManagement](https://github.com/pradeepsingroul/TheLatticeAssignment/assets/104360276/ba4dd39c-6bcd-4f27-b035-2a1bccfa81fb)
