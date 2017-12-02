from bs4 import BeautifulSoup
from selenium import webdriver

driver = webdriver.Chrome("chromedriver.exe")
profile_link = "https://www.linkedin.com/in/diljotsg/"

driver.get(profile_link)

html = driver.page_source
soup = BeautifulSoup(html, "html.parser")

print(soup)
