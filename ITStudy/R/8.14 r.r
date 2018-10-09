#외부 data 가져오고 내보내기

#작업 폴더 설정
setwd("C:\\Users\\ysang\\Documents\\RData")
#작업폴더 확인
getwd()

#파일 읽어들여서 배열에 담기
input5 <- readLines('../RData/scan_4.txt')
input5

fruits <-read.table('fruits.txt') #헤더까지 담김
fruits

fruits <-read.table('fruits.txt',header=T) #헤더가 있음을 알려줌. True
fruits

fruit2 <- read.table('fruits_2.txt') #주석이나 공백 제거
fruit2

fruit2 <- read.table('fruits_2.txt',skip=2) #건너뛸 줄 수를 지정
fruit2

fruit3 <- read.csv('fruits_3.csv')
fruit3


#문자가 들어있는 파일을 불러올 때는
df_csv_exam <- read.csv("csv_exam.csv",stringsAsFactors = F)
df_csv_exam

df_midterm <- data.frame(english = c(90,80,60,70), math = c(50,60,100,20), class = c(1,1,2,2))
df_midterm

write.csv(df_midterm, file = "df midterm.csv")

install.packages("googleVis")
library(googleVis)
install.packages("sqldf")
library(sqldf)
Fruits

write.csv(Fruits,"Fruits_sql.csv",quote=F,row.names=F)
fruits_2 <-read.csv.sql("Fruits_sql.csv", sql="SELECT * FROM file WHERE year =2008")
fruits_2


#Excel 파일로부터 데이터 프레임에 저장하기
install.packages("readxl")
library(readxl)

df_exam <- read_excel("excel_exam.xlsx") #엑셀파일 불러와서 할당
df_exam

mean(df_exam$english)
mean(df_exam$science)

#클립보드에 있는 내용으로 df생성
fruits6 <- read.delim("clipboard",header=T)
fruits6


#web 상의 파일 가져오기
csv_url <- "http://viewportsizes.com/devices.csv"
csv_df <- read.table(file=csv_url, sep=",",header=T, stringsAsFactors = F)

#적재된 데이터프레임 구조 확인
str(csv_df)
#단 숫자를 사용하고 싶다면 as.numeric 사용해야함

#numeric과 Release.Date를 날짜 데이터로 변경
for(x in 4:5){
  csv_df[ ,x] <- as.numeric(csv_df[ ,x])
}
str(csv_df)

#문제는 데이터가 제대로 읽어지지 않아 d 부분이 없음.
#paste로 만들어주자.

for (x in 6){
  csv_df[,x] <- paste(csv_df[,x], "-01",sep="")
}

for(x in 6){
  csv_df[ ,x] <- as.Date(csv_df[ ,x],format="%Y-%m-%d")
}
str(csv_df)


#Open API 활용해서 데이터 불러오기

url<-"http://openapi.airport.kr/openapi/service/StatusOfPassengerFlightsDS/getPassengerArrivalsDS?ServiceKey=uYuuw6N9VO4j%2BAlprhmKJrWJ6%2Fb0lMMLwpTmg3oqfrH4E6LXJdiae8OKfrfKixBgYt%2FVWBbbm30yTjdE9WNltA%3D%3D&airport_code=NRT"
key <- "uYuuw6N9VO4j%2BAlprhmKJrWJ6%2Fb0lMMLwpTmg3oqfrH4E6LXJdiae8OKfrfKixBgYt%2FVWBbbm30yTjdE9WNltA%3D%3D"
api_url <- paste(url,key,"xml","octastatapi419","1","26",sep="/")

api_url

install.packages("XML")
library(XML)

#Open API 호출 주소를 통해 XML을 불러와 parseXml에 담기
parsedXml <- xmlParse(url)

#Xml중 실제 데이터가 담긴 row태그만 df로 변환하기 위해
#getNodeSet 함수를 이용해 row 태그만 골라낸다.
rowXml <- getNodeSet(parsedXml, "//item")

#xmlToDataFrame 함수를 활용해 Xml -> df
api_data <- xmlToDataFrame(rowXml, stringsAsFactors = F)

str(api_data)

#excel 파일 형식으로 저장하기

install.packages("WriteXLS")
library(WriteXLS)

name <- c("Apple", "Banana","Peach")
price <- c(300,200,100)
item <- data.frame(NAME=name, PRICE=price)
item
writeXLS("item","item.xls") #라즈베리?가 깔려야 된다고한다..
