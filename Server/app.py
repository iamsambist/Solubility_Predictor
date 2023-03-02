from flask import Flask,request,jsonify
import pickle
import numpy as np

model=pickle.load(open('model.pkl','rb'))
app=Flask(__name__)

@app.route('/')
def home() :
    return 'hello world'

@app.route('/predict',methods=['POST'])
def predict():
  mlp=request.form.get('MolLogP')
  fmlp=float(mlp)
  mw=request.form.get('MolWt')
  fmw=float(mw)
  nrb=request.form.get('NumRotatableBonds')
  fnrb=float(nrb)
  ap=request.form.get('AromaticProportion')
  fap=float(ap)

  input_query=np.array([[fmlp,fmw,fnrb,fap]])
  result=model.predict(input_query)

  return {'logS' : str(result)}




if __name__=='__main__' :
    app.run(debug=True)
