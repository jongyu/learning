# language: zh-CN
# Created by ZhongYu at 2017/12/25
功能: 登录

  场景大纲: 登录成功
    假如 输入用户名："<username>"
    并且 输入密码："<password>"
    当 点击登录
    那么 登录成功
    例子:
      | username | password |
      | zhongyu  | 12345    |
      | kayaowo  | 54321    |

  场景: 登录失败
    假如 输入用户名：李逍遥
    并且 输入密码：123456
    当 点击登录
    那么 登录失败