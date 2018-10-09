#8.16

library(dplyr)
setwd("C:\\Users\\ysang\\Documents\\RData")
exam <- read.csv("csv_exam.csv")
exam

#반 별 담임교사 명단 생성

name <- data.frame(class = c(1,2,3,4,5),
                           teacher = c("kim","lee","park","choi","jung"))

name

#class 기준 합치기
exam_new <- left_join(exam, name, by = "class")
exam_new

library(ggplot2)
mpg <- as.data.frame(ggplot2::mpg)

#혼자서 해보기
#fuel 데이터프레임 만들기
fuel <- data.frame(fl = c("c","d","e","p","r"),
                   price_fl = c(2.35,2.38,2.11,2.76,2.22),
                   stringsAsFactors = F)

fuel
mpg
#만든 데이터를 기존 데이터와 합치기
mpg <- left_join(mpg, fuel, by="fl")
#잘 추가되었는지 변수 추출해 확ㅇ
mpg %>% 
  select(model, fl, price_fl) %>% 
  head(5)


#지하철 승하차 데이터 관련 실습
subway <- read.csv("1-4호선승하차승객수.csv")
subway

#호선이름 열 추가후 기존 데이터에 넣기
line <- data.frame(노선번호 = c("line_1","line_2","line_3","line_4"),
                   호선이름 = c("블루라인","그린라인","레드라인","옐로우라인"))
line
subway <- left_join(subway, line, by="노선번호")
subway

#벡터로 출력하는 것은 aggregate 함수 이용.

#노선 번호별 승차인원수 합계
subway %>% 
  group_by(노선번호) %>% 
  summarise(승차 = sum(승차))

#노선 번호별 하차 인원수 합계
subway %>% 
  group_by(노선번호) %>% 
  summarise(하차 = sum(하차))

#노선 번호 상관없이 승차 하차 인원수 합계
subway %>% 
  summarise(승차 = sum(승차), 하차 = sum(하차))
  
#노선 번호별 승하차 인원수 합계
subway %>% 
  group_by(노선번호) %>% 
  summarise(승차및하차 = sum(승차+하차))

#시간대별 승하차 인원의 합을 3구간으로 나누기

subway %>% 
  mutate(q = ifelse((승차+하차) >= 3000000, "혼잡",
             ifelse((승차+하차) >= 2000000, "보통", "여유")))


#데이터 정제, 결측치 정제

#결측치 만들기 (결측치 표기 - 대문자 NA)

df <- data.frame(sex = c("M","F",NA,"M","F"),
                 score = c(5,4,3,4,NA))
df

#결측치 확인
is.na(df) #NA값이 있는가?

table(is.na(df)) #결측치 빈도
table(is.na(df$sex)) #특정 변수 결측치 빈도 출력

mean(df$score)
sum(df$score)

#결측치 제거하기 - filter 이용. 여러 변수 동시에 이용 가능
library(dplyr)

df_nomiss <-df %>% filter(!is.na(score))
df_nomiss
mean(df_nomiss$score)
sum(df_nomiss$score)

df_nomiss <- df %>%  filter(!is.na(score) & !is.na(sex))
df_nomiss

#na.omit() 결측치 없는 데이터 추출
df_nomiss2 <- na.omit(df)
df_nomiss2

#함수 이용할 때 결측치 제외하기 (na.rm = T)
mean(df$score, na.rm = T)
sum(df$score, na.rm = T)

#summarise()에서 na.rm = T 사용하기
exam <- read.csv("csv_exam.csv")
exam[c(3,8,15), "math"] <- NA #3,8,15행 math에 NA할당
exam
exam %>% summarise(mean_math = mean(math)) #평균 산출 -> NA
exam %>% summarise(mean_math = mean(math, na.rm = T)) #결측치 제외 후 평균 산출
exam %>% summarise(mean_math = mean(math, na.rm = T),
                   sum_math = sum(math, na.rm = T),
                   median_math = median(math, na.rm = T)) #평균,합계,중앙값 산출

#평균값으로 결측치 대체하기
mean(exam$math, na.rm = T)
exam$math <- ifelse(is.na(exam$math), 55, exam$math) #math가 NA면 55로 대체
table(is.na(exam$math)) #결측치 빈도표 생성 -> 없음

#이상치 정제하기 (Outlier) : 정상범주에서 크게 벗어난 값

outlier <- data.frame(sex = c(1,2,1,3,2,1),
                      score = c(5,4,3,4,2,6))
outlier

table(outlier$sex)
table(outlier$score)

 #결측처리 - sex (3이면 NA할당)
outlier$sex <- ifelse(outlier$sex == 3, NA, outlier$sex)
outlier
 #score가 1-5 아니면 제거
outlier$score <- ifelse(outlier$score > 5, NA, outlier$score)
outlier

 #결측치 제외 후 분석
outlier %>% 
  filter(!is.na(sex) & !is.na(score)) %>% 
  group_by(sex) %>% 
  summarise(mean_score = mean(score))

#극단적인 값 제거 (boxplot에서 벗어나는 값)
mpg <- as.data.frame(ggplot2::mpg)
boxplot(mpg$hwy)

boxplot(mpg$hwy)$stats #상자그림의 통계치 출력
#위아래 극단치가 각각 5, 1 로 나타남. 이 범위를 벗어나는건 극단치

 #12~37 범위를 벗어나면 NA할당
mpg$hwy <- ifelse(mpg$hwy <12 | mpg$hwy > 37, NA, mpg$hwy)
table(is.na(mpg$hwy))

mpg %>%
  group_by(drv) %>% 
  summarise(mean_hwy = mean(hwy, na.rm = T))

#혼자서 해보기 실습
mpg <- as.data.frame(ggplot2::mpg)
#결측치를 일부러 만들어보기
mpg[c(10,14,58,93), "drv"] <- "k" #drv(구동방식)에 이상치 할당
mpg[c(29,43,129,203), "city"] <- c(3,4,39,42) #cty 이상치 할당

table(mpg$drv)
mpg$drv <- ifelse(mpg$drv == "k", NA, mpg$drv)
#다른방법
mpg$drv <- mpg %>% filter(mpg$drv != "k")
table(mpg$drv)

boxplot(mpg$cty)
boxplot(mpg$cty)$stats #9~26까지 유효
mpg$cty <- ifelse(mpg$cty < 9 | mpg$cty > 26, NA, mpg$cty)
boxplot(mpg$cty)

mpg %>%
  filter(!is.na(drv) & !is.na(cty)) %>% 
  group_by(drv) %>% 
  summarise(mean_cty = mean(cty))
