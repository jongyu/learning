*** Settings ***
Library           SeleniumLibrary

*** Test Cases ***
baidu_case
    Open Browser    https://www.baidu.com    chrome
    Input Text    id=kw    SheIn
    Click Button    id=su
    Sleep    2
    ${title}    Get Title
    log    ${title}
    Should Contain    ${title}    SheIn_百度搜索
    Close Browser
