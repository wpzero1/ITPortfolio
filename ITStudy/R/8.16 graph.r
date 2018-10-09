library(ggplot2)

#산점도

#배경 설정
ggplot(data = mpg, aes(x = displ, y = hwy))
#배경에 산점도 추가 (함수를 +로 연결해서 사용)
ggplot(data = mpg, aes(x = displ, y = hwy)) + geom_point()

#x축 범위 3~6 지정, y축 범위 10~30
ggplot(data = mpg, aes(x = displ, y = hwy)) +
  geom_point() +
  xlim(3,6) +
  ylim(10,30)

#막대 그래프
library(dplyr)
mpg <- as.data.frame(ggplot2::mpg)
df_mpg <- mpg %>% 
  group_by(drv) %>% 
  summarise(mean_hwy = mean(hwy))

df_mpg

 #그래프 생성
ggplot(data = df_mpg, aes(x = drv, y = mean_hwy)) +
  geom_col()

 #크기 순 정렬 (reorder)
ggplot(data = df_mpg, aes(x = reorder(drv, -mean_hwy), y = mean_hwy)) +
  geom_col()

 #빈도 막대 그래프
 #x축 범주 변수, y축 빈도
ggplot(data = mpg, aes(x = drv)) +
  geom_bar()

 #x축 연속 변수, y축 빈도
ggplot(data = mpg, aes(x = hwy)) + 
  geom_bar()

mpg
#혼자서 해보기
 #막대
ggplot(data=mpg, aes(x=class, fill=class)) + geom_bar() #fill 쓰면 색상 채워진다..

mpgcty <- mpg %>% 
  filter(class == "suv") %>%  #class 중 suv만 뽑아서 보기
  group_by(manufacturer) %>%  #제조사별로 보기
  summarise(mean_cty = mean(cty)) %>%  #cty연비의 평균 구하기
  arrange(desc(mean_cty)) %>%  #내림차순
  head(5) #5개 출력
mpgcty

ggplot(data=mpgcty, aes(x = manufacturer, y=mean_cty, fill=manufacturer)) + geom_col()


 #빈도수
ggplot(data=mpg, aes(x = class)) + geom_bar()

#시계열그래프
ggplot(data = economics, aes(x = date, y = unemploy)) + geom_line()

#상자그림
ggplot(data = mpg, aes(x = drv, y = hwy)) + geom_boxplot()
