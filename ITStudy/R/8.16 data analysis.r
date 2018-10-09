#Data Analysis

install.packages("foreign") #외부 파일 로드 패키지
library(foreign)
library(dplyr)
library(ggplot2)
library(readxl)

#한국복지패널데이터 분석 준비
raw_welfare <- read.spss(file = "Koweps_hpc10_2015_beta1.sav",
                         to.data.frame = T)

welfare <- raw_welfare #복사본 만들기

#데이터 확인절차
head(welfare)
tail(welfare)
#View(welfare)
dim(welfare)
str(welfare)
summary(welfare)

#변수명 바꾸기(알아보기 쉽게)
welfare <- rename(welfare,
                  sex = h10_g3,
                  birth = h10_g4,
                  marriage = h10_g10,
                  religion = h10_g11,
                  income = p1002_8aq1,
                  code_job = h10_eco9,
                  code_region = h10_reg7)

#성별에 따른 월급 차이
 #변수 검토
class(welfare$sex) #numeric
table(welfare$sex) #이상치 존재 x 단 코드북에서 9가 무응답이라 해줌.
 #이상치 결측처리
welfare$sex <- ifelse(welfare$sex == 9, NA, welfare$sex)

 #결측치 확인
table(is.na(welfare$sex))

 #성별 항목 이름 부여. 
welfare$sex <- ifelse(welfare$sex == 1, "male", "female")      
table(welfare$sex)
qplot(welfare$sex)

#월급 변수 검토 및 전처리
class(welfare$income)
summary(welfare$income)
qplot(welfare$income)
qplot(welfare$income) + xlim(0,1000)
 #이상치 결측 처리
welfare$income <- ifelse(welfare$income %in% c(0,9999), NA, welfare$income)

table(is.na(welfare$income))

#월급 평균표 만들기
sex_income <- welfare %>% 
  filter(!is.na(income)) %>% 
  group_by(sex) %>% 
  summarise(mean_income = mean(income))

sex_income

ggplot(data = sex_income, aes(x = sex, y = mean_income)) + geom_col()

#나이와 월급의 관계 - 몇살 때 월급을 가장 많이 받을까?
class(welfare$birth)
 #이상치 확인
summary(welfare$birth)
qplot(welfare$birth)
 #결측치 확인
table(is.na(welfare$birth))
 #결측 처리 는 생략.

#조사시기 2015년에 따른 파생변수 - 나이 만들기
welfare$age <- 2015 - welfare$birth + 1
summary(welfare$age)
qplot(welfare$age)

#나이와 월급의 관계 분석 (월급 0인 사람 제외하기)
age_income <- welfare %>% 
  filter(!is.na(income)) %>% 
  group_by(age) %>% 
  summarise(mean_income = mean(income))

head(age_income)
ggplot(data = age_income, aes(x = age, y = mean_income)) + geom_line()

welfare <- welfare %>% 
  mutate(ageg = ifelse(age <30, "young",
         ifelse(age <=59, "middle", "old")))
table(welfare$ageg)

qplot(welfare$ageg)

#연령대별 월급 평균표 만들기
ageg_income <- welfare %>% 
  filter(!is.na(income)) %>% 
  group_by(ageg) %>% 
  summarise(mean_income = mean(income))

ageg_income
ggplot(data = ageg_income, aes(x = ageg, y = mean_income)) + geom_col() + 
  scale_x_discrete(limits = c("young", "middle", "old")) #x축 값 순서 변경

#연령대 및 성별 월급 차이 (누적)
sex_income <- welfare %>% 
  filter(!is.na(income)) %>% 
  group_by(ageg, sex) %>% 
  summarise(mean_income = mean(income))
ggplot(data = sex_income, aes(x = ageg, y = mean_income, fill = sex)) + 
  geom_col() +
  scale_x_discrete(limits = c("young", "middle", "old"))

#성별 막대 분리 : dodge 옵션
ggplot(data = sex_income, aes(x = ageg, y = mean_income, fill = sex)) + 
  geom_col(position = "dodge") +
  scale_x_discrete(limits = c("young", "middle", "old"))

# 나이 및 성별 월급 차이 분석
sex_age <- welfare %>% 
  filter(!is.na(income)) %>% 
  group_by(age, sex) %>% 
  summarise(mean_income = mean(income))

head(sex_age)
ggplot(data = sex_age, aes(x = age, y = mean_income, col = sex)) +
  geom_line()

#R 파레트
ggplot(data = sex_income, aes(x = sex, y = mean_income, fill=sex)) + geom_col() +
  scale_fill_brewer(palette = 'Pastel1')
