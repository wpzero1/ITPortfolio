## 함수 정의 부분

def func1() :
    print("Func.py의 func1()이 호출됨.")
    
def func2() : 
    print("Func.py의 func2()가 호출됨.")
    
def func3() :
    print("Func.py의 func3()이 호출됨.")

#소문자->대문자 함수
def my_upper() :
    a = input("글자를 입력하세요")
    print(a.upper())

#급여 계산 함수
def calc_monthly_salary(a,b) :
    return a*b

#실습 A - 암호화 프로그램 암호화/복호화
def en(indata) :
    return indata ^ 456

def de(indata) :
    return indata ^ 456


#주차장 모듈
#주차
def caradd(carList) :
    carin = str(input("주차할 차 이름을 입력하세요"))
    carList.append(carin)
    print("현재 리스트 : %s" % carList)

#출차
def carout(carList,tmp) :
    carout = str(input("뺄 차 이름 입력"))
    while carList.index(carout) + 1 < len(carList) :
          tmp.append(carList.pop())
    carList.pop()    
    while len(tmp)>0 :
          carList.append(tmp.pop())
    print("현재 리스트 : %s" % carList)
    
            
            
    