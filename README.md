# Solubility_Predictor
here you will see the Server folder, which is not the part of Android Application.'remove it to run android application on your machine' but instead it consist 2 files.
    1> Solubility Checker.ipynb
    it is a jupyter notebook file which contain all the neccessary code to build and ml model using linear regression which will predict a value based upon the input data.
    
    2> app.py
    it was a server side code which is being hosted through website called pythonanywhere.com basically it will take input from andorid application through http        communication than it will return the resopance in a json format after calculating the result through builded ml model.
   
   finally in front end side,
   return json will be paresed of course using java and will be fetched to text view to display the output to the user.
