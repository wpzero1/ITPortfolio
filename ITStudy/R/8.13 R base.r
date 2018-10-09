
#기본 연습
1+2
plot(iris$Sepal.Length)
x <- c(1,2,3)
x
mean(x)
max(x)
min(x)
str5 <- c("Hello!","World","is","good!")
str5
paste(str5, collapse = ",") #쉼표를 구분자로 str5의 단어를 하나로 합치
str5_paste <- paste(str5, collapse = " ")
str5_paste
install.packages("ggplot2") #그래프 그릴때 좋은 패키지
library(ggplot2) #ggplot2 패키지 로드

# 함수 사용하기
x <- c("a","a","b","c")
x
# 빈도 그래프 출력
qplot(x)
#ggplot2의 mpg 데이터를 그래프로 만들기
 #data에 mpg, x축에 hwy 변수 지정하여 그래프 생성
qplot(data = mpg, x = hwy)

#기초 문법편
print(1+2)
print('a') #문자 출력시엔 홑따옴
print(pi,digits=3) #digits로 자릿수 지정 가능

1;2;3 #각 명령을 세미콜론으로 구분
1+2; 2*3; 4/2

10000
100000 #0이 5개 이상부터는 e로 표시
1000000
1e2 #1*10^2
3e-1 #소숫점 1자리까지
3e2 #3*10^2

# NA, NULL
cat(1,NA,2) #NA 그대로 출력
cat(1,NULL,2) #NA 제거 출
sum(1,NA,2) #na를 더하니까 na로 출력됨
sum(1,NULL,2) #null값 제외

sum(1,2,NA)
sum(1,2,NA,na.rm=T) #na 제거작

#여러 값으로 구성된 변수 : c() , seq()
var1 <- c(1,2,5,7,8)
var1
var2 <- c(1:5)
var2

var3 <- seq(1, 5)
var3
var4 <- seq(1,10,by=2) #1~10까지 2 간격 연속값으로 생성
var4 

#날짜 형태 지정하기
as.Date("13-08-2018") #의도하지 않은 값이 나옴
as.Date("13-08-2018",format="%d-%m-%Y")
as.Date("01111914",format="%d%m%y") #y 포맷에 따라 값이 다르게 나온다.
as.Date(10,origin="2018-08-13") #주어진 날짜 기준으로 10일 후
as.Date(-10,origin="2018-08-13") #주어진 날짜 기준으로 10일 전 
as.Date("2018-08-31") - as.Date("2018-08-13")

install.packages("lubridate")
library(lubridate)
date <- now() #현재 날짜 시간 넣기
date

year(date) #년도만 출력
month(date,label=T) #월을 출력하되 영문이름으로 출력
month(date,label=F)
day(date)
wday(date,label=T)
wday(date,label=F) #요일을 출력하되 가중치 숫자로 출력. 일요일부터 1
date2 <- date - days(2) #2일전 날짜 출
date2
date+years(1)
date+months(1)
date+hours(1)
date+minutes(1)
date+seconds(1)
date <- hm("22:30"); date
date <- hms("22:30:15"); date

#변수에 연속적인 값 대입하기
seq1 <- 1:5
seq1
seq2 <- "a":"f" #변수는 연속적 할당이 안
date1 <- seq(from=as.Date('2014-01-01'),to=as.Date('2014-01-05'),by=1)
date1         

#변수에 담아둔 값 제거하기
str1 <- "I'm James Seo"
rm(str1)
str1
objects()
rm(list=ls()) #모든 변수 삭제
objects()

#실습
#Q1. 시험점수 변수 만들고 출력
test <- c(80,60,70,50,90)
test

#Q2. 전체 평균 구하기
mean(test)
#Q3. 전체 평균 변수 만들고 출력하기
testmean <- mean(test)
testmean

# 특정 위치 값 제어하기

vec1 <- c(1,2,3,4,5)
vec1[3] #3번째 요소만 보여주기
vec1[-3] #3번째 요소 빼고 보여주기
vec1[-1:-3] #1번 ~ 3번 요소 제외
vec1[2] <- 6 #2번째 항목을 6으로 변
vec1

vec2 <- c(1,2,3,3,4,5)
vec2
append(vec2,10,after=3) #3번째 위치 뒤에 10 넣기. 유지시키려면 저장 필요
append(vec2,11,after=0) #가장 앞자리
var4 <- c(1,2,3,4,5)
var1 <- c(1,2,3)
var1 + var4 #두 벡터 길이가 다르면 순환 원리..

#Factor형 - 범주형 data 표현. 제한된 범주 안에서 선택됨

v_character <-c('사과','복숭아','사과','오렌지','사과','오렌지','복숭아')
v_character
v_factor <-factor(v_character) #같은 값들끼리 level로 묶음
v_factor #복숭아 사과 오렌지 (각 1,2,3번 레벨). 남/여를 1/2로 받는 방식처럼.

mode(v_factor)
str(v_factor)

v_factor_to_char<-as.character(v_factor)
v_factor_to_char #벡터와 같은 형태로 다시 만들어진다.
v_factor_to_num<-as.numeric(v_factor)
v_factor_to_num #숫자로

#등급을 나타내는 문자 벡터
ex_label <-c("하하", "중하", "중", "중상", "상상")

#서열형 데이터 팩터 생성
ordered_factor <- factor(ex_label, ordered=T)
ordered_factor

#레벨 입력 항목을 이용해 서열 순으로 범주 순서 정의
factor(ex_label, levels=c("하하", "중하", "중", "중상", "상상"), ordered=T)


#기초문법편 실습(보고서)


#2
#1.
data4 <- seq(from=as.Date("2015-01-01"), to=as.Date("2015-01-31"), by=1)
data4
vec1 <- c('사과','배','감','버섯','고구마')
vec1
vec1[-3]

#3
vec1 <- c('봄','여름','가을','겨울')
vec2 <- c('봄','여름','늦여름','초가을')

union(vec1,vec2)
setdiff(vec1,vec2)

intersect(vec1,vec2)

#실습문제(1)
#1
v1 <- c(1:10)
v1
#2
v1[1:5]
#3
v1[3:7]
#4
v1[-1:-5]
#5
v1[-3:-7]
#6
v1[3] <- 0
v1[6] <- 0
v1
#7
v1[9] <- 0
v1
#8
class(v1)
#9
v_num <- v1
class(v1)

#실습문제(2)
#1
append(v1,0,after=0)
#2
v1 <- append(v1,11,after=11)
v1
#3
v1 <- append(v1,14:20,after=12)
v1
#4
append(v1,12:13,after=11)
#5
v2 <- 100
#6
v1+v2
#7
v2 <- c(100,200,300)
#8
v1+v2

#실습문제(3)
#1
union(v1,v2)

#2
setdiff(v1,v2)
#3
intersect(v2,v1)

#4
names(v2) <- c("A","B","C")
v2

#5
v3 <- seq(5,50, 5); v3

#6
v4 <- rep(5:6,3); v4

#7
v5 <- rep(-1:1,each=3); v5

#8
length(v5)

#9
15 %in% v3

#10
vv <- 55 %in% v3
vv


#Matrix

mat1 <- matrix(c(1,2,3,4))
mat1

mat2 <- matrix(c(1,2,3,4),nrow=2)
mat2

mat3 <- matrix(c(1,2,3,4),nrow=2,byrow=T)
mat3

mat3[,1] #모든 행의 1열 값
mat3[1,] #1행의 모든 열 값
mat3[1,1] #1행 1

mat4 <- matrix(c(1,2,3,4,5,6,7,8,9), nrow=3,byrow=T)
mat4

mat4 <- rbind(mat4,c(11,12,13)) #rbind()로 행 추가(가로줄)
mat4
mat4 <- rbind(mat4,c(15,16,17,18)) #길이가 다르면 에러가 난

mat5 <- matrix(c('a','b','c','d'),nrow=2,byrow=T)
mat5

mat5 <-cbind(mat5,c('e','f')) #cbind()로 열 추가 (세로줄)
mat5

#List
#리스트 안에 벡터가 존재한다. key는 벡터로 존재
list1 <- list(name='James Seo', address='Seoul', tel='010-8706-4712',pay=500)
list1

#특정 key값만 조회하기
list1$name
list1[1:2]

#List에 새로운 요소 추가/삭제
list1$birth <- '1975-10-23'
list1

list1$birth <- NULL
list1

