# calculator-springboot
> # 1. How to Run:
    i]Take Clone of calculator-springboot repo or download directly.<br>
    ii]Check class which have main() method.<br>
    iii]Run this class accordingly on IDE.<br>

> 2.**You can test this Api's while using Postman or paste below url's on Chrome(any browser)**.

> 3. **API urls of Calculator**:-
   
i]**Request**: GET /calculatorapi/v1/addition?number1=12&number2=15 <br>
**Response**: { "answer": 27, "detail": "12 + 15 = 27" } 

ii]**Request**: GET /calculatorapi/v1/subtraction?number1=12&number2=15 <br>
**Response**: { "answer": -3, "detail": "12 - 15 = -3" } 

iii]**Request**: GET /calculatorapi/v1/multiplication?number1=12&number2=15 <br>
**Response**: { "answer": 180, "detail": "12 * 15 = 180" } 

iv]**Request**: GET /calculatorapi/v1/division?number1=12&number2=15 <br>
**Response**: { "answer": 0.8, "detail": "12 / 15 = 0.8" } 

v]**Request**: GET /calculatorapi/v1/square/{5} <br>
**Response**: { "answer": 25, "detail": "square of 5 = 25" } 

vi]**Request**: GET /calculatorapi/v1/squareroot/{225} <br>
**Response**: { "answer": 15, "detail": "squareroot of 225 = 15" } 

vii]**Request**: GET /calculatorapi/v1/factorial/{5} <br>
**Response**: { "answer": 120, "detail": "5! = 120" } 

viii]**Request**: POST /calculatorapi/v1/min-max <br>
**Body** { "numbers" : [10,-5,7,15,-7,-6,16,19,-15,9] } <br>
**Response**: { "min": -15, "max": 19 }

**_Note_**:-Please add Localhost in Urls before Run

Example:-

For Addition:-http://localhost:8080/calculatorapi/v1/addition?number1=10.5&number2=20.3
