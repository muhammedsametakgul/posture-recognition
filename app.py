from fastapi import FastAPI, HTTPException
from pydantic import BaseModel
from typing import List
import requests

app = FastAPI()
posture_data = []  # Gelen verileri saklamak için bir liste

class PostureStatus(BaseModel):
    timestamp: str
    posture: str

@app.post("/posture/")
async def add_posture_status(posture: PostureStatus):
    posture_data.append(posture.dict())
    
    latest_posture = posture.dict()
    try:
        response = requests.post("http://localhost:8080/sendPosture", json=latest_posture)
        response.raise_for_status()  
    except requests.RequestException as e:
        raise HTTPException(status_code=500, detail="Failed to send data to message queue service")
    
    return {"message": "Posture data added and sent successfully"}

@app.get("/posture/", response_model=List[PostureStatus])
async def get_posture_status():
    # Tüm verileri JSON olarak döndür
    return posture_data
