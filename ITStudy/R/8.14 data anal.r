#8.14 Basic of Data Analysis
setwd("C:\\Users\\ysang\\Documents\\RData")

library(ggplot2)

#데이터 파악하기
#head(), tail(), View() - 뷰어 창에서 데이터 확인 dim() - 데이터차원 출력

mpg <- as.data.frame(ggplot2::mpg)
head(mpg)
tail(mpg)
View(mpg)
dim(mpg)
str(mpg) #데이터 속성
summary(mpg) #요약통계량

#데이터 수정 - 변수명 바꾸기
library(dplyr)

df_raw <- data.frame(var1=c(1,2,1), var2 =c(2,3,2))
df_raw
df_new <- df_raw #복사본 생ㅅ
df_new

#변수명 바꾸기
df_new <- rename(df_new, v2=var2) #var2를 v2로 수정
df_new

#파생변수 만들기
df <- data.frame(var1 = c(4,3,8), var2 = c(2,6,1))
df

df$var_sum <- df$var1 + df$var2 #합을 구하는 파생변수 생성
df

df$var_mean <- (df$var1 + df$var2)/2
df

#mpg 통합 연비 변수 만들기
mpg
mpg$total <- (mpg$cty + mpg$hwy)/2 #통합 연비 변수 생성
head(mpg)
mean(mpg$total)

summary(mpg$total)
hist(mpg$total) #히스토그램 생성

#조건문으로 합격 판정 변수 만들기
mpg$test <- ifelse(mpg$total >=20, "pass", "fail") #20 이상이면 pass, 그렇지 않으면 fail부여

mpg

head(mpg, 20)

mpg$grade <- ifelse(mpg$total >=30, "A", ifelse(mpg$total >=20, "B", "C"))

head(mpg, 20)
table(mpg$grade) #등급 빈도표 생성
qplot(mpg$grade) #등급 빈도막대 그래프 생성

#분석 도전

#데이터 불러오기
library(dplyr)

midwest <- as.data.frame(ggplot2::midwest)
head(midwest)
str(midwest)

#변수명 바꾸기
midwest <- rename(midwest, total = poptotal)
midwest <- rename(midwest, asian = popasian)
str(midwest)

#전체 인구 대비 아시아 인구 백분율 파생변수 만들기
midwest$asianper <- (midwest$asian / midwest$total)*100
midwest
hist(midwest$asianper)
asiamean <- mean(midwest$asianper)

midwest$asiangrade <- ifelse(midwest$asianper >= asiamean, "large", "small")
                           
midwest

#-----------------------------------#
#데이터 가공하기
library(dplyr)
exam <- read.csv("csv_exam.csv")
exam

#exam에서 class가 1인 경우만 추출하여 출력. 파이프연산자 이용.
#Ctrl + Shift + M으로 %>% 기호 입력. 부정은 !=
exam %>% filter(class == 1)
#2반인 경우 추출
exam %>% filter (class == 2)
#1반이 아닌 경우
exam %>% filter (class != 1)
#영어 점수가 80점 이상인 경우
exam %>%  filter(english >= 80)

#여러 조건 충족하는 행 추출하기
#1반이면서 수학 점수가 50점 이상인 경우
exam %>% filter (class == 1 & math >= 50)

# or의 경우는 |
exam %>% filter(math >= 90 | english >= 90)

#%in%기호 - 추출 -> 다른 곳에 쓰고 싶다면 변수 할당
exam %>% filter(class %in% c(1,3,5))

#추출한 행으로 데이터 만들기
class1 <- exam %>% filter(class == 1)
class2 <- exam %>% filter(class == 2)
mean(class1$math)
mean(class2$math)

#혼자서 해보기
#Q1

mpg <- as.data.frame(ggplot2::mpg)
displ4 <- mpg %>% filter(displ <= 4)
mean(displ4$hwy)

displ5<- mpg %>% filter(displ >= 5)
mean(displ5$hwy)
# -> 배기량(displ)이 4 이하인 자동차가 고속도로 연비가 더 높다

#Q2
audi <- mpg %>% filter(manufacturer == "audi")
toyota <- mpg %>% filter(manufacturer == "toyota")
mean(audi$cty)
mean(toyota$cty)
# -> toyota가 더 높다

#Q3
cars <- mpg %>% filter(manufacturer %in% c("chevorlet","ford","honda") )
mean(cars$hwy)

#dplyr 함수 조합하기

exam %>% 
  filter(class == 1) %>%  #class가 1인 행 추출
  select(english) #english 추출


#파생변수 추가하기 : mutate() 함수
exam %>%
  mutate(total = math + english + science) %>%  #종합 변수 추가
  head #일부 추출
#이걸 계속 쓰고 싶다면 저장을 해야한다.

exam %>%
  mutate(total = math + english + science,
         mean = (math + english + science)/3) %>%  #총평균 변수 추가
  head #일부 추출

#mutate에 ifelse 적용
exam %>%
  mutate(test = ifelse(science >=60, "pass", "fail")) %>%
  head

#추가한 변수를 dplyr 코드에 바로 활용하기
exam %>%
  mutate(total = math + english + science) %>%  #종합 변수 추가
  arrange(total) %>%  #총합 변수 기준 정렬
  head #일부 추출

#혼자서 해보기
#연결된 dplyr 구문으로 만들면 더 간결. 변수 추가작업을 하나의 mutate()로 구성 가능하다.
mpg %>%
  mutate(total = cty+hwy, avg=(total)/2) %>%
  arrange(desc(avg)) %>% 
  head(3)

#------------#
  
#요약 통계량 한번에 산출하기
  exam %>% 
    group_by(class) %>% 
    summarise(mean_math = mean(math),
              sum_math = sum(math),
              median_math = median(math),
              n = n())


#dplyr 조합하기 - 회사별 suv 자동차 관련 출력
mpg %>%
  group_by(manufacturer) %>% 
  filter(class == "suv") %>% 
  mutate(total = (cty + hwy)/2) %>% 
  summarise(mean_suv = mean(total)) %>% 
  arrange(desc(mean_suv)) %>% 
  head(5)

#2018base 분석
#1번
base <- read.csv("2018base.csv")
base
str(base)

#2번
base$타율 <- base$안타/base$타수

#3번 - 안타를 만든 후, 루타수 구하기
base <- base %>%
        mutate(단타 = 안타 - X2루타 - X3루타 - 홈런, 루타수 = 안타+X2루타*2+X3루타*3+홈런*4)

#4번 - 장타율
base <- base %>%
        mutate(장타율 = 타수/루타수)
base

#5번 - 장타율 상위 5명출 추추
base %>%
  arrange(desc(장타율)) %>% 
  head(5)

#6번 - 타율 상위 5명 추출
base %>%
  arrange(desc(타율)) %>% 
  head(5)

#7번 - 홈런 상위 5명 추출
base %>%
  arrange(desc(홈런)) %>% 
  head(5)
