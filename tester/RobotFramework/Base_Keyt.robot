*** Test Cases ***
variable
    ${var}    Set Variable    Hello World！
    log    ${var}

list
    ${var}    Create List    A    B    C
    log    ${var}

catenate
    ${var }    Catenate    Hello    World    ！
    log    ${var

time
    ${var}    get time
    log    ${var}
    sleep    5
    ${var}    get time
    log    ${var}

if
    ${var}    Set variable    100
    run keyword if    ${var}>=90    log    优秀
    ...    ELSE IF    ${var}<=70    log    良好
    ...    ELSE IF    ${var}<=60    log    及格
    ...    ELSE    log    不及格

for
    : FOR    ${var}    IN RANGE    10
    \    log    ${var}

evaluate
    ${var}    Evaluate    random.randint(1,100)    random
    log    ${var}
