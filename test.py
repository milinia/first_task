import math
import pandas

excel_data = pandas.read_excel('example0-1.xlsx')
df = pandas.DataFrame(excel_data)

#1 - исключаются все, кто не из Москвы и старше 30 лет
data_after_deleting = df.drop(df[(df['region'].str.contains("Москва") == False) | (df['year'] > 30)].index)

#2
mask_for_region = df['region'].str.contains("Омск", regex=False)
region_data = df.loc[mask_for_region]

#3
mask_for_profession = df['profession'].str.contains("Программирование", regex=False)
profession_data = df.loc[mask_for_profession]
total_age = profession_data['year'].sum()
average_age = total_age // len(profession_data.index)

#4
def divide_by_12(x):
    if x == x:
        if len(x) >= 2 :
            x[1] = str(int((int(x[1]) / 12) * 10 % 10))
    return x
region_data['experience'] = region_data['experience'].str.findall('-?\d+\,?\d*').apply(divide_by_12).str.join(".")
