import unittest
from appium import webdriver


class CalculatorTestCase(unittest.TestCase):

    def setUp(self):
        # noinspection PyDictCreation
        capabilities = {}
        capabilities['automationName'] = 'Appium'
        capabilities['platformName'] = 'Android'
        capabilities['platformVersion'] = '7.0'
        capabilities['deviceName'] = 'HUAWEI'
        capabilities['noReset'] = False
        capabilities['unicodeKeyboard'] = True
        capabilities['resetKeyboard'] = True
        capabilities['appPackage'] = 'com.android.calculator2'
        capabilities['appActivity'] = '.Calculator'
        self.driver = webdriver.Remote("http://localhost:4723/wd/hub", capabilities)
        self.driver.implicitly_wait(60)

    def test_plus(self):
        driver = self.driver
        driver.find_element_by_id('digit_4').click()
        driver.find_element_by_accessibility_id("加").click()
        driver.find_element_by_id("digit_9").click()
        driver.find_element_by_id("eq").click()
        result = driver.find_element_by_id("formula").text
        self.assertEqual('13', result)

    def test_cut(self):
        driver = self.driver
        driver.find_element_by_id("digit_8").click()
        driver.find_element_by_id("op_sub").click()
        driver.find_element_by_id("digit_6").click()
        driver.find_element_by_id("eq").click()
        result = driver.find_element_by_id("formula").text
        self.assertEqual('2', result)

    def test_multiply(self):
        driver = self.driver
        driver.find_element_by_id("digit_3").click()
        driver.find_element_by_id("op_mul").click()
        driver.find_element_by_id("digit_7").click()
        driver.find_element_by_id("eq").click()
        result = driver.find_element_by_id("formula").text
        self.assertEqual('21', result)

    def test_divided(self):
        driver = self.driver
        driver.find_element_by_id("digit_8").click()
        driver.find_element_by_id("op_div").click()
        driver.find_element_by_id("digit_2").click()
        driver.find_element_by_id("eq").click()
        result = driver.find_element_by_id("formula").text
        self.assertEqual('4', result)

    def tearDown(self):
        driver = self.driver
        driver.quit()


if __name__ == '__main__':
    unittest.main()
