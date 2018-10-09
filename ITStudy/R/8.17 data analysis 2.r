#8.17 데이터 분석 프로젝트 이어서
setwd("C:\\Users\\ysang\\Documents\\RData")
library(foreign)
library(dplyr)
library(ggplot2)
library(readxl)

#한국복지패널데이터 분석 준비
raw_welfare <- read.spss(file = "Koweps_hpc10_2015_beta1.sav",
                         to.data.frame = T)

welfare <- raw_welfare #복사본 만들기
#변수명 바꾸기(알아보기 쉽게)
welfare <- rename(welfare,
                  sex = h10_g3,
                  birth = h10_g4,
                  marriage = h10_g10,
                  religion = h10_g11,
                  income = p1002_8aq1,
                  code_job = h10_eco9,
                  code_region = h10_reg7)
#직업별 월급 차이

class(welfare$code_job)
table(welfare$code_job)

 #전처리 - 직업분류코드 목록 불러오기
list_job <- read_excel("Koweps_Codebook.xlsx", col_names = T, sheet = 2)
head(list_job)
dim(list_job)
 #welfare에 직업명 결합(left_join)
welfare <- left_join(welfare, list_job, id = "code_job")
welfare %>% 
  filter(!is.na(code_job)) %>% 
  select(code_job, job) %>% 
  head(10)

 #직업별 월급 평균표
job_income <- welfare %>% 
  filter(!is.na(job) & !is.na(income)) %>% 
  group_by(job) %>% 
  summarise(mean_income = mean(income))

head(job_income)
welfare$job

top10 <- job_income %>% 
  arrange(desc(mean_income)) %>% 
  head(10)

top10 #상위 10위 추출

bottom10 <- job_income %>% 
  arrange(mean_income) %>% 
  head(10)

bottom10 #하위 10위 추출

ggplot(data = top10, aes(x = reorder(job, mean_income), y=mean_income)) + geom_col() + coord_flip() #세로형 막대그래프로 변경

ggplot(data = bottom10, aes(x = reorder(job, -mean_income),
                            y = mean_income)) +
  geom_col() +
  coord_flip() + 
  ylim(0,850) #최소값이라는 것을 보여주기 위해 기준을 상위와 같게

#성별 직업 빈도 - 성별로 어떤 직업이 가장 많을까?

 #성별 항목 이름 부여. 
welfare$sex <- ifelse(welfare$sex == 1, "male", "female") 

 #남성 직업 빈도 상위 10개 추출
job_male <- welfare %>% 
  filter(!is.na(job) & sex == "male") %>% 
  group_by(job) %>% 
  summarise(n = n()) %>% 
  arrange(desc(n)) %>% 
  head(10)

job_male

job_male <- welfare %>% 
  filter(!is.na(job) & sex == "male") %>%
  group_by(job) %>% 
  summarise(n = n()) %>% 
  arrange(desc(n)) %>% 
  head(10)

job_male

 #여성 직업 빈도 상위 10개 추출
job_female <- welfare %>% 
  filter(!is.na(job) & sex == "female") %>% 
  group_by(job) %>% 
  summarise(n = n()) %>% 
  arrange(desc(n)) %>% 
  head(10)

job_female  

 #남성 / 여성 그래프 만들기
ggplot(data = job_male, aes(x = reorder(job,n), y=n)) +
  geom_col() +
  coord_flip()

ggplot(data = job_female, aes(x = reorder(job,n), y=n)) +
  geom_col() + 
  coord_flip()

#종교 유무에 따른 이혼율
 #변수 검토 - 종교
class(welfare$religion)
table(welfare$religion)
 
#전처리 - 종교 유무 이름 부여
welfare$religion <- ifelse(welfare$religion == 1, "yes", "no")
table(welfare$religion)

qplot(welfare$religion)

 #변수 검토 - 혼인상태
class(welfare$marriage)
table(welfare$marriage)

 #전처리 - 이혼 여부 변수
welfare$group_marriage <- ifelse(welfare$marriage == 1, "marriage", ifelse(welfare$marriage == 3, "divorce", NA))
table(welfare$group_marriage) #변수 확인
table(is.na(welfare$group_marriage)) #NA값의 개수 확인

qplot(welfare$group_marriage)

 #이혼율 표 만들기
religion_marriage <- welfare %>% 
  filter(!is.na(group_marriage)) %>% 
  group_by(religion, group_marriage) %>% 
  summarise(n = n()) %>% 
  mutate(tot_group = sum(n)) %>% 
  mutate(pct = round(n/tot_group*100, 1))

 #이혼 추출
divorce <- religion_marriage %>% 
  filter(group_marriage == "divorce") %>% 
  select(religion, pct)

divorce

ggplot(data = divorce, aes(x = religion, y = pct)) + geom_col()

#연령대 및 종교 유무에 따른 이혼율 분석
 #연령대별 이혼율 표 만들기

 #전에 만들어던 나이, 연령대
welfare$age <- 2015 - welfare$birth + 1
welfare$age
welfare <- welfare %>% 
  mutate(ageg = ifelse(age <30, "young",
                       ifelse(age <=59, "middle", "old")))
table(welfare$ageg)

ageg_marriage <- welfare %>% 
  filter(!is.na(group_marriage)) %>% 
  group_by(ageg, group_marriage) %>% 
  summarise(n = n()) %>% 
  mutate(tot_group = sum(n)) %>% 
  mutate(pct = round(n/tot_group*100, 1))

ageg_marriage

 #초년 제외, 이혼 추출
ageg_divorce <- ageg_marriage %>% 
  filter(ageg != "young" & group_marriage == "divorce") %>% 
  select(ageg, pct)

ageg_divorce

ggplot(data = ageg_divorce, aes(x = ageg, y = pct)) + geom_col()

#연령대, 종교유무, 결혼상태별 비율표 만들기
ageg_religion_marriage <- welfare %>% 
  filter(!is.na(group_marriage) & ageg != "young") %>% 
  group_by(ageg, religion, group_marriage) %>% 
  summarise(n = n()) %>% 
  mutate(tot_group = sum(n)) %>% 
  mutate(pct = round(n/tot_group*100, 1))

ageg_religion_marriage

 #이혼율 표 만들기
df_divorce <- ageg_religion_marriage %>% 
  filter(group_marriage == "divorce") %>% 
  select(ageg, religion, pct)

df_divorce

ggplot(data = df_divorce, aes(x = ageg, y = pct, fill = religion )) + geom_col(position = "dodge")

#지역별 연령대 비율
 #지역 변수 검토 및 전처리
class(welfare$code_region)
table(welfare$code_region)
 #지역 코드 목록 만들기
list_region <- data.frame(code_region = c(1:7),
                          region = c("서울",
                                     "수도권(인천/경기)",
                                     "부산/경남/울산",
                                     "대구/경북",
                                     "대전/충남",
                                     "강원/충북",
                                     "광주/전남/전북/제주도"))

list_region

 #welfare에 지역명 변수 추가
welfare <- left_join(welfare, list_region, id = "code_region")
welfare %>% 
  select(code_region, region) %>% 
  head

 #지역별 연령대 비율표 만들기

region_ageg <- welfare %>%
  group_by(region, ageg) %>% 
  summarise(n = n()) %>% 
  mutate(tot_group = sum(n)) %>% 
  mutate(pct = round(n/tot_group*100, 2))

head(region_ageg)

 #그래프
ggplot(data = region_ageg, aes(x=region, y = pct, fill = ageg))+
  geom_col() + 
  coord_flip()

 #막대 정렬하기
 #노년층 비율 내림차순 정렬
list_order_old <- region_ageg %>% 
  filter(ageg == "old") %>% 
  arrange(pct)

list_order_old

order <- list_order_old$region
order

ggplot(data = region_ageg, aes(x = region, y = pct, fill = ageg)) + geom_col() + 
  coord_flip() + 
  scale_x_discrete(limits = order)

 #연령대 순으로 막대 색깔 나열하기
class(region_ageg$ageg)
levels(region_ageg$ageg)
region_ageg$ageg <- factor(region_ageg$ageg,
                           level = c("old","middle","young"))
class(region_ageg$ageg)
levels(region_ageg$ageg)

ggplot(data = region_ageg, aes(x = region, y = pct, fill = ageg)) +
  geom_col() +
  coord_flip() + 
  scale_x_discrete(limits = order)
