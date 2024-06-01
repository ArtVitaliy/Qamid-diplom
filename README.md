# **Дипломный проект профессии «Инженер по тестированию»**

## Мобильное приложение «V Hospice»
## Описание приложения

Приложение даёт функционал по работе с претензиями хосписа и включает в себя:

- Информацию о претензиях и функционал для работы с ними;
- Новостную сводку хосписа;
- Тематические цитаты.

## Документация

1. [Задание дипломного проекта;](https://github.com/netology-code/qamid-diplom)
2. [План проверки и автоматизации приложения;](https://github.com/ArtVitaliy/Qamid-diplom/blob/main/Plan.md)
3. [Чек-лист проверок;](https://docs.google.com/spreadsheets/d/1kQ6vpCaJTMUEEoDTime2flL6ZoDHk7rB/edit?usp=sharing&ouid=118063972788702184653&rtpof=true&sd=true)
4. [Тест-кейсы;](https://docs.google.com/spreadsheets/d/1x-ntThZRrbxASpRJxUwKIiB6Ya1WooSt/edit?usp=sharing&ouid=118063972788702184653&rtpof=true&sd=true)
5. [Отчет о проведённом тестировании;](https://github.com/ArtVitaliy/Qamid-diplom/blob/main/results.md)

## **Процедура запуска авто-тестов:**

**1 способ (без Allure)**

1. Склонировать репозиторий 

2. Открыть проект fmh-android в Android Studio.

3. Запустить эмулятор (API 29) или подключить устройство для тестирования.

4. Запустить тесты консольной командой `./gradlew connectedAndroidTest.`

**2 способ (с выгрузкой Allure-results)**

1. Склонировать репозиторий 

2. Открыть проект fmh-android в Android Studio.

3. Запустить эмулятор (API 29) или подключить устройство для тестирования.

4. Запустить тесты консольной командой `./gradlew connectedAndroidTest.`

5. По завершению, выгрузите каталог /data/data/ru.iteco.fmhandroid/files/allure-results с эмулятора или тестового устройства (при помощи Device Manager). Лучше выгрузить в корень директории проекта.

6. Выполните локально консольную команду allure serve, находясь на уровень выше каталога allure-results.