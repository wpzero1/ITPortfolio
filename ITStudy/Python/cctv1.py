
# coding: utf-8

# In[3]:


import pandas as pd


# In[5]:


CCTV_Seoul = pd.read_csv('../data/01.CCTV_in_Seoul.csv', encoding='utf-8')
CCTV_Seoul.head()


# In[6]:


print(type(CCTV_Seoul))


# In[7]:


CCTV_Seoul.columns


# In[8]:


CCTV_Seoul.columns[0]


# In[9]:


CCTV_Seoul.rename(columns={CCTV_Seoul.columns[0] : '구별'}, inplace=True)
CCTV_Seoul.head()


# In[10]:


pop_Seoul = pd.read_excel('../data/01.population_in_Seoul.xls',
                          header = 2,
                          usecols = 'B,D,G,J,N',
                          encoding='utf-8')
pop_Seoul.head()


# In[11]:


pop_Seoul.rename(columns={pop_Seoul.columns[0] : '구별',
                          pop_Seoul.columns[1] : '인구수',
                          pop_Seoul.columns[2] : '한국인',
                          pop_Seoul.columns[3] : '외국인',
                          pop_Seoul.columns[4] : '고령자'}, inplace=True)
pop_Seoul.head()


# In[12]:


CCTV_Seoul.sort_values(by='소계', ascending=True).head(5)


# In[13]:


CCTV_Seoul.sort_values(by='소계', ascending=False).head(5)


# In[14]:


CCTV_Seoul['최근증가율']= (CCTV_Seoul['2016년'] + CCTV_Seoul['2015년'] +                      CCTV_Seoul['2014년']) / CCTV_Seoul['2013년도 이전'] * 100
CCTV_Seoul.sort_values(by='최근증가율', ascending=False).head(5)


# In[15]:


pop_Seoul.head()


# In[16]:


pop_Seoul.drop([0], inplace=True)
pop_Seoul.head()


# In[17]:


pop_Seoul['구별'].unique()


# In[18]:


pop_Seoul['외국인비율'] = pop_Seoul['외국인'] / pop_Seoul['인구수']*100
pop_Seoul['고령자비율'] = pop_Seoul['고령자'] / pop_Seoul['인구수']*100
pop_Seoul.head()


# In[20]:


pop_Seoul.sort_values(by='인구수', ascending=False).head(5)


# In[21]:


pop_Seoul.sort_values(by='외국인', ascending=False).head(5)


# In[22]:


data_result = pd.merge(CCTV_Seoul, pop_Seoul, on='구별')
data_result.head()


# In[23]:


left = pd.DataFrame({'key': ['K0', 'K4', 'K2', 'K3'],
                      'A' : ['A0','A1', 'A2', 'A3'],
                      'B' : ['B0', 'B1', 'B2', 'B3']})
right = pd.DataFrame({'key' : ['K0', 'K4', 'K2', 'K3'],
                      'C' : ['C0', 'C1', 'C2', 'C3'],
                      'D' : ['D0', 'D1', 'D2', 'D3']})


# In[24]:


left


# In[26]:


right


# In[27]:


pd.merge(left, right, on='key')


# In[28]:


del data_result['2013년도 이전']
del data_result['2014년']
del data_result['2015년']
del data_result['2016년']
data_result.head()


# In[29]:


data_result.set_index('구별', inplace=True)
data_result.head()


# In[30]:


import pandas as pd
import numpy as np


# In[31]:


np.corrcoef(data_result['고령자비율'], data_result['소계'])


# In[32]:


np.corrcoef(data_result['외국인비율'], data_result['소계'])


# In[34]:


np.corrcoef(data_result['인구수'], data_result['소계'])


# In[36]:


import matplotlib.pyplot as plt
get_ipython().run_line_magic('matplotlib', 'inline')


# In[37]:


plt.figure()
plt.plot([1,2,3,4,5,6,7,8,9,8,7,6,5,4,3,2,1,0])
plt.show()


# In[38]:


import platform

from matplotlib import font_manager, rc
plt.rcParams ['axes.unicode_minus'] = False

if platform.system() == 'Darwin':
    rc('font', family='AppleGothic')
elif platform.system() == 'Windows':
    path = "c:/Windows/Fonts/malgun.ttf"
    font_name = font_manager.FontProperties(fname=path).get_name()
    rc('font', family=font_name)
else:
    print('Unknown system. Sorry.')


# In[39]:


data_result.head()


# In[42]:


plt.figure()
data_result['소계'].sort_values().plot(kind='barh', grid=True, figsize=(10,10))
plt.show()


# In[50]:


data_result['CCTV비율'] = data_result['소계'] / data_result['인구수'] * 100
data_result['CCTV비율'].sort_values().plot(kind='barh', grid=True, figsize=(10,10))
plt.show()


# In[44]:


plt.figure(figsize=(6,6))
plt.scatter(data_result['인구수'], data_result['소계'], s=50)
plt.xlabel('인구수')
plt.ylabel('CCTV')
plt.grid()
plt.show()


# In[45]:


fp1 = np.polyfit(data_result['인구수'], data_result['소계'], 1)
fp1


# In[46]:


f1=np.poly1d(fp1)
fx=np.linspace(100000,700000,100)


# In[47]:


plt.figure(figsize=(10,10))
plt.scatter(data_result['인구수'], data_result['소계'], s=50)
plt.plot(fx, f1(fx), ls='dashed', lw=3, color='g')
plt.xlabel('인구수')
plt.ylabel('CCTV')
plt.grid()
plt.show()

