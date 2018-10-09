# R Data Frame

english <- c(90,80,60,70) #영어 점수 변수
english

math <- c(50,60,100,20) #수학 점수 변수
math

df_midterm <-data.frame(english,math)
df_midterm #데이터 프레임을 생성해 여기에 할당

class <- c(1,1,2,2) # 반 변수
class
df_midterm <- data.frame(english,math,class)
df_midterm

mean(df_midterm$english) #english로 평균 산출
mean(df_midterm$math) #math로 평균 산출

#벡터 뿐만 아니라 행렬로도 데이터 프레임 생성 가능
sales2 <- matrix(c(1,'Apple',500,5,
                  +2,'Peach',200,2,
                  +3,'Banana',100,4,
                  +4,'Grape',50,7),nrow=4,byrow=T)
sales2

df1 <- data.frame(sales2) #데이터프레임으로 변환
df1

names(df1) <- c('NO','NAME','PRICE','QTY') #라벨명 추가
df1

sales <- df1 #sales라는 변수로 이용

sales$NAME #level들어가면 factor형태. 문자일때는 factor로 자동변환되는 때가 많다.
#stringAsFactors를 써야된다고..
sales
sales[1,3] #1행 3열에 있는 데이터
sales[1,] #1행 모든 데이터
sales[,3] #3열 모든 데이터

sales[c(1,2),]

sales[,c(1,2)]
sales[,c(1:3)]

head(sales,2) #숫자는 데이터 개수를 의미 : 데이터 위쪽에서 2개 가져오라
tail(sales,3) #데이터 아래에서 3개 가져오라

summary(sales) #요약

#데이터 프레임 조회(View의 첫글자 V는 대문자)
View(iris)

sales$PRICE
str(sales) #str은 구조 파악 용도 (원래 factor로 저장되어있음)
sales$PRICE<-as.numeric(sales$PRICE) #PRICE 열에 대해 숫자로 바꿔줘야함
sales$PRICE<-c(500,200,100,50) #바꿀경우 숫자가 잘못 저장되기 때문에 다시 벡터값 넣어줌
str(sales)

summary(sales)

sales$PRICE
sales$PRICE > 100

#order 함수 정렬
order(sales$PRICE)
sales[order(sales$PRICE),]
sales

#그룹 지어보기

# com_data를 만들 벡터 생성
dept <- c('개발부', '개발부', '개발부', '개발부','영업부', '영업부', '영업부', '영업부')
position <- c('과장', '과장', '차장', '차장','과장', '과장', '차장', '차장')
name <- c('김가윤', '고동산', '박기성', '이소균','황가인', '최유리', '김재석', '유상균')
salary <- c(5400, 5100, 7500, 7300, 4900, 5500, 6000, 6700)
worktime <- c(15, 18, 10, 12, 17, 20, 8, 9)

# com_data 생성
com_data <- data.frame(dept, position, name, salary, worktime)
com_data

#부서(dept)별 급여(salary) 평균
aggregate(salary ~ dept, com_data, mean) #기준되는 항목을 ~ 뒤에 쓰기

#부서별 급여 및 근무시간 평균
aggregate(cbind(salary, worktime) ~ dept, com_data, mean)

#부서&직급별 급여 평균
aggregate(salary ~ dept + position, com_data, mean)

edit(sales)

#subset으로 원하는 조건만 조회

subset(sales,QTY<5)
subset(sales,PRICE==200)


subset(sales,name=='Apple') #조건이 문자일 경우 반드시 홑/쌍따옴표 처리

#데이터 프레임에서 특정 컬럼만 골라내서 새로운 형태 만들기
no <- c(1,2,3,4,5)
name <- c("서진수","주시현","최경우","이동근","윤정웅")
address <- c("서울","대전","포항","경주","경기")
tel <- c(1111,2222,3333,4444,5555)
hobby <- c("독서","미술","놀고먹기","먹고놀기","노는애감시하기")
member <- data.frame(NO=no,NAME=name,ADDRESS=address,TEL=tel,HOBBY=hobby)
member

member2 <- subset(member,select=c(NO,NAME,TEL)) #특정 컬럼만 지정
member2

member3 <- subset(member,select= -TEL) #특정 컬럼만 제외하
member3

#실습
#Q1
product <- c("사과", "딸기", "수박")
price <- c(1800,1500,3000)
q <- c(24,38,13)

fruitdf <- data.frame(product,price,q)
fruitdf
names(fruitdf) <- c("제품","가격","판매량")
fruitdf
#Q2
str(fruitdf)
mean(fruitdf$price)
mean(fruitdf$q)

#실습문제-보고서
#1.
NO <- c(1,2,3)
NAME <-c("apple","banana","peach")
PRICE <-c(100,200,300)
df1 <- data.frame(NO,NAME,PRICE)
df1

#2
NO <- c(10,20,30)
NAME <-c("train","car","airplane")
PRICE <-c(1000,2000,3000)
df2 <- data.frame(NO,NAME,PRICE)
df2

#실습문제(1)-보고서
name <- c("김길동","강길동","박길동")
kor <- c(100,90,85)
mat <- c(90,95,98)
eng <- c(80,98,100)

s <-data.frame(name,kor,mat,eng)
s

names(s) #열 이름
nrow(s) #행 개수
s[c(1,2)] #1,2 열
s[c(1,3)] #1,3 열
subset(s,select=name) #name 열 출력

subset(s,kor>90) #국어 점수가 90점 이상인 행만 출력
subset(s,name=='박길동')
s <- rbind(s,data.frame(name="최길동",kor=80,mat=90,eng=93))
s

#실습문제(2)-보고서
t <- data.frame(name = c("강길동", "박길동", "최길동"), kor = c(100,90,92),mat = c(90,95,100))
t

t <- cbind(t,data.frame(sci=c(88,80,94))) #새로운 열 추가
t
ncol(t) #열 개수
t[c(-2),]#2행 제외
t[c(-1)] #1열 제외
t[c(1,4,2,3),]

#실습문제(3)-보고서
merge(s,t)
merge(s,t,all=T) #모든 데이터 출력
cbind(s,t)
cbind(t,s)

tt <- subset(t,select=c(name,kor,mat))
ss <- subset(s,select=c(name,kor,mat))
rbind(tt,ss)
rbind(ss,tt)
