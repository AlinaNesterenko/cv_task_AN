# Проект по автоматизации E2E сценария расчета кредита
## Содержание:

- [Использованный стек](#использованный-стек)
- [Запуск тестов из терминала](#запуск-тестов-из-терминала)
- [Jenkins](#jenkins)
- [Allure-отчет](#allure-отчет)
- [Allure TestOps](#allure-testops)
- [Jira](#jira)
- [Уведомления в Telegram](#уведомления-в-telegram)
- [Видео запуска тестов](#видео-запуска-тестов)

## Использованный стек

<p align="center">
<img width="10%" title="IntelliJ IDEA" src="media/logo/Intelij_IDEA.svg">
<img width="10%" title="Java" src="media/logo/Java.svg">
<img width="10%" title="Gradle" src="media/logo/Gradle.svg">
<img width="10%" title="JUnit5" src="media/logo/JUnit5.svg">
<img width="10%" title="Selenide" src="media/logo/Selenide.svg">
<img width="10%" title="Selenoid" src="media/logo/Selenoid.svg">
<img width="10%" title="Allure Report" src="media/logo/Allure_Report.svg">
<img width="10%" title="Allure TestOps" src="media/logo/AllureTestOps.svg">

<img width="10%" title="GitHub" src="media/logo/GitHub.svg">
<img width="10%" title="Jenkins" src="media/logo/Jenkins.svg">
<img width="10%" title="Telegram" src="media/logo/Telegram.svg">
<img width="10%" title="Jira" src="media/logo/Jira.svg">
</p>

- Для автотестов использовался язык <code>Java</code>.
- Cборщиком выступает - <code>Gradle</code>.
- Также используются фреймворки <code>JUnit 5</code> и [Selenide](https://selenide.org/).
- При запуске тестов используется [Selenoid](https://aerokube.com/selenoid/).
- Возможен удаленный запуск тестов через <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота.
- Настроена индеграция с <code>Allure TestOps</code> и <code>Jira</code>

Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

## Запуск автотестов

### Запуск тестов из терминала
```
gradle clean bank_test
```
При выполнении команды, данные тесты запустятся удаленно в <code>Selenoid</code>.

```
clean bank_test
-Dremote=${remote}
-Dbrowser=${browser}
-Dversion=${version}
-Dsize=${size}
```
Параметры сборки задаются при сборке и могут быть переопределены

### Параметры сборки

* <code>browser</code> – браузер, в котором будут выполняться тесты. По-умолчанию - <code>chrome</code>.
* <code>version</code> – версия браузера, в которой будут выполняться тесты. По-умолчанию - <code>100.0</code>.
* <code>size</code> – размер окна браузера, в котором будут выполняться тесты.
* <code>remote</code> – адрес удаленного сервера, на котором будут запускаться тесты.

## Jenkins
Настроен запуск тестов в <code>Jenkins</code>. От находится [тут](https://jenkins.autotests.cloud/job/AN_qa_22_cv_task/). 
<p align="center">
<img title="Jenkins Build" src="media/screenshots/screen-Jenkins.png">
</p>

## Allure-отчет
После выполнения тестов генирируется Allure-отчет. Найти его можно  [тут](https://jenkins.autotests.cloud/job/AN_qa_22_cv_task/12/allure/)
<img title="Test Results in Alure" src="media/screenshots/Allure-Report.png">
</p>

## Allure TestOps

Выполнена интеграция сборки <code>Jenkins</code> с <code>Allure TestOps</code>.
Результат выполнения автотестов отображается в <code>Allure TestOps</code>
На Dashboard в <code>Allure TestOps</code> отображена статистика пройденных тестов. Ссылка [тут](https://allure.autotests.cloud/launch/32948).

<p align="center">
<img title="Allure TestOps DashBoard" src="media/screenshots/Allure-TestOps.png">
</p>

## Jira

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>. В Тестовом сценарии в <code>Allure TestOps</code> отображается номер тикета в <code>Jira</code>

<img title="TestOps -> Jira" src="media/screenshots/Allure TestOps-Jira.png">
</p>

А в <code>Jira</code> задаче отображается информация, какие тест-кейсы были написаны в рамках задачи.
Задача [тут](https://jira.autotests.cloud/browse/HOMEWORK-983)
<p align="center">
<img title="Jira Task" src="media/screenshots/Jira.png">
</p>

## Уведомления в Telegram

После завершения сборки, бот созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/screenshots/telegram.png">
</p>

## Видео запуска тестов

К каждому тесту в отчете прилагается видео прогона.
<p align="center">
  <img title="Selenoid Video" src="media/screenshots/video2.gif">
</p>