from datetime import datetime
import requests

def send_posture_status(status):
    url = "http://127.0.0.1:8000/posture/" 
    timestamp = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
    data = {
        "timestamp": timestamp,
        "posture": status
    }
    try:
        response = requests.post(url, json=data)
        if response.status_code == 200:
            print("Posture data sent successfully.")
        else:
            print("Failed to send posture data:", response.text)
    except requests.exceptions.RequestException as e:
        print("Could not connect to FastAPI server:", e)
