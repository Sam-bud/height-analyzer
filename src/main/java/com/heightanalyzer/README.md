# Height Analyzer 🧍‍♂️📏

This project estimates human height from an image using a hybrid Java + Python approach.

---

## 🚀 Overview

- **Frontend:** None (API-based interaction)
- **Backend (Java):** Spring Boot app that:
  - Accepts image uploads via REST API
  - Forwards images to the Python service
  - Parses the response and returns results
- **Python Microservice:** FastAPI-based image processing (mocking AI now)

---

## 🧰 Tech Stack

| Language | Framework    | Purpose               |
|----------|--------------|------------------------|
| Java     | Spring Boot  | Main REST API server   |
| Python   | FastAPI      | Image analysis service |
| Gradle   |              | Java build tool        |
| Uvicorn  |              | Python ASGI server     |
| Postman  |              | API testing            |

---

## 🔌 API Endpoints

### `POST /api/analyze`

**Request:**
- `multipart/form-data`
  - `file`: image file (JPG/PNG)

**Response:**

```json
{
  "status": "success",
  "estimated_height_cm": 173.6,
  "confidence": 0.93
}
