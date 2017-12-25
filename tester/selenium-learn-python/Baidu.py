from selenium import webdriver

# executable_path="驱动路径"
# driver = webdriver.Chrome(executable_path="/Applications/chromedriver")
driver = webdriver.Chrome()
driver.maximize_window()
driver.get("https://www.baidu.com")
driver.find_element_by_name("wd").send_keys("钟宇的博客")
driver.find_element_by_id("su").click()
