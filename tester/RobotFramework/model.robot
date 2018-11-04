*** Keywords ***
addition
    [Arguments]    ${a}    ${b}
    ${c}    Evaluate    ${a} + ${b}
    log    ${c}
    [Return]    ${c}

range
    [Arguments]    ${count}
    :FOR    ${var}    IN RANGE    ${count}
    \    log    ${var}
