package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.PageObject.CommonPageFunctions.PageIsReached;
import static ru.iteco.fmhandroid.ui.PageObject.CommonPageFunctions.clickItem;
import static ru.iteco.fmhandroid.ui.PageObject.CommonPageFunctions.selectField;
import static ru.iteco.fmhandroid.ui.PageObject.CommonPageFunctions.waitPage;
import static ru.iteco.fmhandroid.ui.utilities.LoginData.trueLogin;
import static ru.iteco.fmhandroid.ui.utilities.LoginData.truePassword;
import static ru.iteco.fmhandroid.ui.utilities.Utils.waitDisplayed;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.PageObject.CreateNewsPage;
import ru.iteco.fmhandroid.ui.PageObject.LoginPage;
import ru.iteco.fmhandroid.ui.PageObject.MainPage;
import ru.iteco.fmhandroid.ui.PageObject.NewsPage;
import ru.iteco.fmhandroid.ui.utilities.Utils;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тест-кейсы для проведения функционального тестирования вкладки Новости мобильного приложения 'Мобильный хоспис'")
public class NewsTest {

    private final String NewsTitle = "Объявление";
    private final String newsMenuItem = "News";



    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE,
            String.valueOf(System.currentTimeMillis()));

    @Before
    public void setUp() {
        try {
            waitPage(MainPage.mainPageTag);
        } catch (Exception e) {
            waitPage(LoginPage.loginPageTag);
            selectField(LoginPage.loginField);
            LoginPage.feelField(LoginPage.loginField,trueLogin);
            selectField(LoginPage.passwordField);
            LoginPage.feelField(LoginPage.passwordField,truePassword);
            clickItem(LoginPage.signInButton);
            waitPage(MainPage.mainPageTag);
            PageIsReached(MainPage.mainPageTag);
        }
    }

    @Story("Case 10. Добавление новой новости с текущей датой и временем")
    @Description("Создание новой новости с текущей датой и временем во вкладке 'Новости' мобильного приложения 'Мобильный хоспис' (Позитивный)")
    @Test
    public void addFreshNewsCurrentDataTest() {
        String newsDescription = Utils.getRandomNewsDescription();
        clickItem(MainPage.allNewsHeadline); //all news
        clickItem(NewsPage.editNewsButton);
        clickItem(NewsPage.addNewsButton);
        CreateNewsPage.chooseCategory(NewsTitle);
        CreateNewsPage.addNewsCurrentDate();
        CreateNewsPage.addNewsCurrentTime();
        CreateNewsPage.addNewsDescription(newsDescription);
        CreateNewsPage.saveFreshNews();
        waitPage(MainPage.mainPageTag);
        MainPage.clickMainMenuItem(newsMenuItem);
        waitPage(NewsPage.newsList);
        NewsPage.clickFreshNews();
        onView(isRoot()).perform(waitDisplayed(R.id.news_item_description_text_view, 5000));
        NewsPage.findAddedNews(newsDescription);
    }

    @Story("Case 11. Добавление новой новости с текущей датой и временем через 'Главное меню'")
    @Description("Создание новой новости с текущей датой и временем через вкладку 'Главное меню' мобильного приложения 'Мобильный хоспис' (Позитивный)")
    @Test
    public void addFreshNewsCurrentDataMainMenuTest() {   //добавление новой новости через главное меню с текущей датой и временем
        String newsDescription = Utils.getRandomNewsDescription();
        MainPage.clickMainMenuItem(newsMenuItem);
        waitPage(NewsPage.newsList);
        clickItem(NewsPage.editNewsButton);
        clickItem(NewsPage.addNewsButton);
        CreateNewsPage.chooseCategory(NewsTitle);
        CreateNewsPage.addNewsCurrentDate();
        CreateNewsPage.addNewsCurrentTime();
        CreateNewsPage.addNewsDescription(newsDescription);
        CreateNewsPage.saveFreshNews();
        waitPage(MainPage.mainPageTag);
        MainPage.clickMainMenuItem(newsMenuItem);
        waitPage(NewsPage.newsList);
        NewsPage.clickFreshNews();
        NewsPage.findAddedNews(newsDescription);

    }

    @Story("Case 12. Фильтрация новостей по категориям")
    @Description("Фильтрация новостей по выбранной категории во вкладке 'Новости' с помощью кнопки 'Фильтр' мобильного приложения 'Мобильный хоспис' (Позитивный)")
    @Test
    public void newsFilteringByCategoryTest() {
        clickItem(MainPage.allNewsHeadline); //all news
        waitPage(NewsPage.newsList);
        clickItem(NewsPage.filterNewsButton);
        NewsPage.chooseCategoryOfNews(NewsTitle);
        NewsPage.selectStartFilterTimeInterval();
        NewsPage.selectEndFilterTimeInterval();
        clickItem(NewsPage.applyFilterButton);
        waitPage(NewsPage.newsList);
        NewsPage.checkNewsCategory(NewsTitle, 0);
    }


}


