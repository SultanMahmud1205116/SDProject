package com.example.sultanmahmud.databasedemoversionone.helper;

import com.example.sultanmahmud.databasedemoversionone.model.*;

import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;
import java.text.*;
import java.util.*;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.*;
import android.util.Log;

/**
 * Created by sultanmahmud on 5/15/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    // Logcat tag
    public static final String LOG = "DatabaseHelper";

    private static DatabaseHelper sInstance;

    // Database Version
    private static final int DATABASE_VERSION = 1; // last changed version was 6

    // Database Name
    public static final String DATABASE_NAME = "newFinanceManager5";
    private static final String TABLE_ASSET = "asset";
    private static final String TABLE_ASSET_CATEGORY = "asset_category";
    private static final String TABLE_USER = "user";

    private static final String CREATE_ASSET_TABLE = "CREATE TABLE if not exists asset (asset_id	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,asset_category_id	INTEGER NOT NULL,assetname	TEXT NOT NULL,user_id	INTEGER NOT NULL,asset_value	REAL NOT NULL, foreign key (asset_category_id) references asset_category(asset_category_id), foreign key (user_id) references user(user_id))";
    private static final String CREATE_ASSET_CATEGORY_TABLE = "CREATE TABLE if not exists asset_category (asset_category_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,asset_category_name TEXT NOT NULL)";
    private static final String CREATE_USER_TABLE = "CREATE TABLE if not exists user  (user_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,name TEXT NOT NULL,email TEXT,password TEXT NOT NULL,personal_savings REAL,age INTEGER NOT NULL,gender TEXT NOT NULL,city TEXT NOT NULL,retirement_status TEXT NOT NULL,freedom_fighter_status TEXT NOT NULL,tin TEXT)";
    private static final String CREATE_BANK_TABLE = "CREATE TABLE if not exists bank (" +
            " bank_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            " bank_name TEXT NOT NULL" +
            ")";
    private static final String CREATE_BANK_LOAN = "CREATE TABLE if not exists bank_loan (" +
            " bank_loan_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            " bank_id INTEGER NOT NULL," +
            " user_id INTEGER NOT NULL," +
            " loan_interest REAL NOT NULL," +
            " payment_date TEXT NOT NULL," +
            " loan_amount REAL NOT NULL," +
            " paid_amount REAL NOT NULL," +
            " deadline TEXT NOT NULL," +
            " account_number TEXT NOT NULL, foreign key (bank_id) references bank(bank_id), foreign key (user_id) references user(user_id)" +
            ")";
    private static final String CREATE_BANK_SAVINGS = "CREATE TABLE if not exists bank_savings (" +
            " bank_savings_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            " bank_id INTEGER NOT NULL," +
            " user_id INTEGER NOT NULL," +
            " interest_rate REAL NOT NULL," +
            " maturity_date TEXT NOT NULL," +
            " total_savings_amount REAL NOT NULL," +
            " account_number TEXT NOT NULL, foreign key (bank_id) references bank(bank_id), foreign key (user_id) references user(user_id)" +
            ")";
    private static final String CREATE_EXPENDITURE_CATEGORIES = "" +
            "CREATE TABLE  if not exists expenditure_category (" +
            " expenditure_category_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            " expenditure_category_name TEXT NOT NULL" +
            ")";
    private static final String CREATE_EXPENDITURE = "CREATE TABLE if not exists expenditure (" +
            " expenditure_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            " expenditure_category_id INTEGER NOT NULL," +
            " user_id INTEGER NOT NULL," +
            " date TEXT NOT NULL," +
            " expenditure_amount REAL NOT NULL, foreign key (expenditure_category_id) references expenditure_category(expenditure_category_id), foreign key (user_id) references user(user_id) " +
            ")";
    private static final String CREATE_INCOME_SOURCE_CATEGORY = "" +
            "CREATE TABLE if not exists income_source_category (" +
            " income_source_category_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            " income_source_category_name TEXT NOT NULL" +
            ")";
    private static final String CREATE_INCOME = "CREATE TABLE if not exists income (" +
            " income_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            " income_source_category_id INTEGER NOT NULL," +
            " user_id INTEGER NOT NULL," +
            " income_date TEXT NOT NULL," +
            " income_amount REAL NOT NULL," +
            " exempted_amount REAL NOT NULL," +
            " net_taxable_amount REAL NOT NULL," +
            " FOREIGN KEY(income_source_category_id) REFERENCES income_source_category(income_source_category_id)," +
            " FOREIGN KEY(user_id) REFERENCES user(user_id)" +
            ")";
    private static final String CREATE_LOAN_GIVEN = "" +
            "CREATE TABLE if not exists loan_given (" +
            " loan_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            " given_by INTEGER NOT NULL," +
            " given_to INTEGER NOT NULL," +
            " start_date TEXT NOT NULL," +
            " end_date TEXT NOT NULL," +
            " amount REAL NOT NULL, foreign key (given_by) references user(user_id)" +
            ")";
    private static final String CREATE_SAVINGS_CATEGORY = "" +
            "CREATE TABLE if not exists savings_category (" +
            " savings_category_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            " savings_category_name TEXT NOT NULL" +
            ")";
    private static final String CREATE_SAVINGS = "CREATE TABLE if not exists savings (" +
            " savings_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            " savings_category_id INTEGER NOT NULL," +
            " user_id INTEGER NOT NULL," +
            " savings_amount REAL NOT NULL," +
            " savings_description TEXT NOT NULL," +
            " savings_date TEXT NOT NULL, foreign key (savings_category_id) references savings_category(savings_category_id), foreign key (user_id) references user(user_id)" +
            ")";
    private static final String CREATE_ADMIN = "CREATE TABLE if not exists admin (" +
            " admin_user_name INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            " admin_name TEXT NOT NULL," +
            " password TEXT NOT NULL" +
            ")";
    private static final String CREATE_TAX_CALCULATION_PARAMETERS = "CREATE TABLE if not exists tax_calculation_parameters (" +
            " first_slot_if_freedom_fighter REAL NOT NULL," +
            " first_slot_if_retired REAL NOT NULL," +
            " first_slot_if_female REAL NOT NULL," +
            " regular_first_slot REAL NOT NULL," +
            " second_slot REAL NOT NULL," +
            " third_slot REAL NOT NULL," +
            " fourth_slot REAL NOT NULL," +
            " fifth_slot REAL NOT NULL," +
            " first_slot_multiplier REAL NOT NULL," +
            " second_slot_multiplier REAL NOT NULL," +
            " third_slot_multiplier REAL NOT NULL," +
            " fourth_slot_multiplier REAL NOT NULL," +
            " fifth_slot_multiplier REAL NOT NULL," +
            " tax_lowest_highest_value REAL NOT NULL," +
            " tax_lowest_second_highest_value REAL NOT NULL," +
            " tax_lowest_lowest_value REAL NOT NULL," +
            " year TEXT NOT NULL," +
            " tax_lowest_highest_place TEXT NOT NULL," +
            " tax_lowest_second_highest_place TEXT NOT NULL" +
            ")";


    private static final String INITIAL_USER_LIST = "INSERT INTO user (user_id, name, email, password, personal_savings, age, gender, city, retirement_status, freedom_fighter_status, tin) VALUES" +
            "('1', 'Sultan', '1205116.sm@ugrad.cse.buet.ac.bd', 'Sajal', '1255967', 22, 'male', 'Dhaka', 'NO', 'NO', '122353249645032')," +
            "('4', 'Amina', 'amina@ymail.com', 'aminanisha', '1000000', 70, 'female', 'Gopalgonj', 'YES', 'NO', NULL)," +
            "('7', 'Chocolate', 'choco@candymail.com', '222', '5000', 0, '', '', '', '', NULL)," +
            "('10', 'g', 'aa', 'h', '88', 0, '', '', '', '', NULL)," +
            "('11', 't', 'w', 't', '0', 0, '', '', '', '', NULL)," +
            "('13', 'affleck', 'aff', 'aff', '4', 0, '', '', '', '', NULL)," +
            "('15', 'Nisha', 'rabbithole@gmail.com', 'nisha', '5555555', 64, 'Female', 'Gopalgonj', 'No', 'Yes', 'iedk323')," +
            "('16', 'aaa', 'aaa@gmail.com', 'aaa', '1234', 45, 'male', 'Dhaka', 'yes', 'no', 'fffse23')," +
            "('17', 'bbb', 'bbb@gmail.com', 'bbb', '234', 66, 'female', 'Chittagong', 'No', 'no', '432kdg')," +
            "('18', 'ccc', 'ccc@gmail.com', 'ccc', '9504', 66, 'male', 'Dhaka', 'no', 'Yes', 'ad984023')";
    private static final String INITIAL_ASSET_CATEGORY_LIST = "INSERT INTO asset_category (asset_category_id, asset_category_name) VALUES" +
            "('1', 'business_capital')," +
            "('2', 'director_shareholdings_in_limited_compnanies')," +
            "('3', 'non_agricultural_property')," +
            "('4', 'agricultural_property')," +
            "('5', 'shares/debentures')," +
            "('6', 'saving_certificate/unit_certificate/bond')," +
            "('7', 'prize_bond/savings_scheme')," +
            "('8', 'loans_given')," +
            "('9', 'other_investment')," +
            "('10', 'motor_vehicles')," +
            "('11', 'jewellery')," +
            "('12', 'furniture')," +
            "('13', 'electronic_equipment')," +
            "('14', 'cash_in_hand')," +
            "('15', 'cash_in_bank')," +
            "('16', 'other_deposits')," +
            "('17', 'other_assets')," +
            "('18', 'mortgages_secured_on_property_on_land')," +
            "('19', 'unsecured_loans')," +
            "('22', 'net_wealth_as_on_last_date_of_this_income_year')," +
            "('23', 'net_wealth_as_on_last_date_of_prev_income_year')," +
            "('24', 'family_expenditure')," +
            "('25', 'source_of_funnd_Shown_return_income')," +
            "('26', 'source_of_fund_tax_exempted')," +
            "('27', 'source_of_fund_other_receipts')," +
            "('28', 'Number_of_adult_children')," +
            "('29', 'Number_of_minor_children')," +
            "('30', 'less_liabilities')";
    private static final String INITIAL_ASSET_LIST = "INSERT INTO asset (asset_id, asset_category_id, assetname, user_id, asset_value) VALUES" +
            "(4, '10', 'money', '7', '5698')," +
            "(5, '8', 'hinge', '11', '3426')," +
            "(7, '17', 'mvezgh', '13', '347075')," +
            "(8, '11', 'helo', '1', '40000')," +
            "(9, '16', 'World', '1', '333333')," +
            "(10, '11', 'gui', '1', '3333')," +
            "(11, '5', 'Frt', '1', '9999')," +
            "(12, '8', 'loan given to Amina Rahman', '1', '6450')," +
            "(13, '15', 'balance in account HDOE08422KF', '1', '45683')," +
            "(14, '1', 'Hello', '1', '1020')," +
            "(15, '7', 'World', '1', '123456')," +
            "(16, '7', 'World', '1', '123456')," +
            "(17, '8', 'loan given to Amina Rahman', '1', '10242')," +
            "(18, '15', 'balance in account OEW345', '1', '1034')," +
            "(19, '15', 'balance in account UEOSA035OI', '1', '334')," +
            "(20, '1', 'RRR', '1', '4455')," +
            "(21, '1', 'New Asset', '1', '1234')," +
            "(22, '15', 'balance in account TREIO04823Q', '1', '32221')," +
            "(23, '8', 'loan given to Ibrahim Tahmid', '1', '200')," +
            "(24, '1', 'SecondHello', '1', '2233')," +
            "(25, '1', 'ThirdHello', '1', '6535')," +
            "(26, '1', 'FourthHello', '1', '12346')," +
            "(27, '15', 'balance in account r2d2', '1', '12')," +
            "(28, '8', 'loan given to Israt Zaman', '1', '1212')," +
            "(29, '1', 'Row', '1', '123123')," +
            "(30, '1', 'Nisha the rabbit', '1', '8493')," +
            "(31, '1', 'FIrst', '1', '123456')," +
            "(32, '15', 'balance in account WE23432', '1', '213294')," +
            "(33, '1', 'loan from disha', '1', '20')";

    private static final String INITIAL_BANK_LIST = "INSERT INTO bank (bank_id, bank_name) VALUES" +
            "('1', 'Sonali Bank')," +
            "('2', 'Rupali Bank')," +
            "('3', 'Standard Chartered Bank')," +
            "('4', 'Agrani Bank')," +
            "('5', 'IFIC Bank')," +
            "('6', 'Islami Bank');";


    private static final String INITIAL_BANK_LOAN_LIST = "INSERT INTO bank_loan (bank_loan_id, bank_id, user_id, loan_interest, payment_date, loan_amount, paid_amount, deadline, account_number) VALUES" +
            "(1, '1', '1', '5', '2015-11-01', '34000', 12000, '2015-12-06', 'KDE3456724')," +
            "(2, '2', '1', '9', '2015-11-17', '109079', 6090, '2015-12-01', 'RTY6530965')," +
            "(3, '3', '1', '2', '2015-05-11', '10234', 234, '2016-03-16', 'SHDPR123442OO')," +
            "(4, '1', '1', '3', '2015-10-12', '543131', 6666, '2016-04-26', 'TREIO04823Q')," +
            "(5, '1', '1', '2', '2015-12-15', '23', 12, '2015-12-24', 'w2')," +
            "(6, '1', '1', '2', '2015-12-07', '1234', 345, '2015-12-31', 'r2d2')," +
            "(7, '1', '1', '3', '2015-12-13', '23434', 843, '2015-12-31', 'ee');";
    private static final String INITIAL_BANK_SAVINGS_LIST = "INSERT INTO bank_savings (bank_savings_id, bank_id, user_id, interest_rate, maturity_date, total_savings_amount, account_number) VALUES" +
            "(1, '1', '1', '3', '2015-12-23', '23450', 'SE2344320JHF')," +
            "(2, '2', '1', '7', '2016-08-18', '34592', 'OI432403MC')," +
            "(3, '3', '4', '9', '2016-05-11', '934432', 'PP320930LO')," +
            "(4, '2', '1', '8', '2015-07-06', '45683', 'HDOE08422KF')," +
            "(5, '1', '1', '5', '2016-04-08', '1034', 'OEW345')," +
            "(6, '1', '1', '1', '2015-10-12', '2334', 'UEOSA035OI')," +
            "(7, '1', '1', '6', '2016-06-14', '32221', 'TREIO04823Q')," +
            "(8, '1', '1', '1', '2015-12-24', '12', 'r2d2')," +
            "(9, '1', '1', '9', '2015-12-06', '213294', 'WE23432');";
    private static final String INITIAL_EXPENDITURE_CATEGORY_LIST = "INSERT INTO expenditure_category (expenditure_category_id, expenditure_category_name) VALUES" +
            "('1', 'personal_and_fooding')," +
            "('2', 'tax_paid_including_deduction_at_source_of_last_financial_year')," +
            "('3', 'accomodation')," +
            "('4', 'transport')," +
            "('5', 'electric_bill_residence')," +
            "('6', 'gas_bill_residence')," +
            "('7', 'telephone_bill_residence')," +
            "('8', 'education_children')," +
            "('9', 'personal_expenses_foreign_travel')," +
            "('10', 'festival_and_others')," +
            "('11', 'others')," +
            "('12', 'house_repair/collection')," +
            "('13', 'municipal/local_tax')," +
            "('14', 'wasa_bill_residence')," +
            "('15', 'interest_on_loan/mortgage/capital_charge')," +
            "('16', 'insurance_premimum')," +
            "('17', 'vacancy_allowance')," +
            "('18', 'others_for_house_property')," +
            "('19', 'contribution_to_deferred_annuity')," +
            "('20', 'contribution_to_provident_fund')," +
            "('21', 'contribution_to_super_annuation_fund')," +
            "('22', 'contribution_to_zakat_fund')," +
            "('23', 'land_revenue');";
    private static final String INITIAL_EXPENDITURE_LIST = "INSERT INTO expenditure (expenditure_id, expenditure_category_id, user_id, date, expenditure_amount) VALUES" +
            "(1, '7', '1', '2015-08-10', '23411')," +
            "(2, '7', '1', '2015-09-01', '3302')," +
            "(3, '4', '4', '2015-09-01', '8753')," +
            "(4, '16', '1', '2015-12-01', '12342')," +
            "(5, '19', '1', '2015-03-01', '34265')," +
            "(6, '20', '1', '2013-03-01', '26503')," +
            "(7, '21', '1', '2015-06-01', '36545')," +
            "(8, '22', '1', '2010-03-01', '34595')," +
            "(9, '1', '1', '2015-05-12', '12942')," +
            "(10, '2', '1', '2015-12-09', '324243')," +
            "(11, '1', '1', '2015-12-29', '1234');";
    private static final String INITIAL_INCOME_SOURCE_CATEGORY_LIST = "INSERT INTO income_source_category (income_source_category_id, income_source_category_name) VALUES" +
            "('1', 'salary_basic_pay')," +
            "('2', 'salary_special_pay')," +
            "('3', 'salary_dearness_allowance')," +
            "('4', 'salary_house_rent_allowance')," +
            "('5', 'salary_medical_allowance')," +
            "('6', 'salary_servant_allowance')," +
            "('7', 'salary_leave_allowance')," +
            "('8', 'salary_honorarium/reward/fee')," +
            "('9', 'salary_overtime_allowance')," +
            "('10', 'salary_bonus/ex_gratia')," +
            "('11', 'salary_other_allowance')," +
            "('12', 'salary_contribution_to_recognized_provident_fund')," +
            "('13', 'salary_interest_accured_on_recognized_provident_fund')," +
            "('14', 'salary_deemed_income_for_transport_facility')," +
            "('15', 'salary_deemed_income_for_free_furnished/unfurnished_accomodation')," +
            "('16', 'salary_others')," +
            "('17', 'annual_rental_income')," +
            "('18', 'agricultural_income')," +
            "('19', 'business_income')," +
            "('20', 'share_of_profit_in_a_firm')," +
            "('21', 'income_of_spouse/minor_children')," +
            "('22', 'capital_gains')," +
            "('23', 'other_income')," +
            "('24', 'foreign_income')," +
            "('25', 'interest_on_securities')," +
            "('26', 'hakooona_matata');";
    private static final String INITIAL_INCOME_LIST = "INSERT INTO income (income_id, income_source_category_id, user_id, income_date, income_amount, exempted_amount, net_taxable_amount) VALUES" +
            "(1, '1', '1', '2015-08-04', '100000', '2000', '23000')," +
            "(2, '13', '1', '2015-07-13', '1239832', '2334', '254342')," +
            "(3, '6', '4', '2015-10-08', '100', '33', '67')," +
            "(4, '2', '1', '2015-09-14', '23423', '0', '23423')," +
            "(5, '4', '1', '2015-09-21', '20000', '10000', '20000')," +
            "(6, '1', '1', '2015-12-13', '4444', '1111', '3333')," +
            "(7, '2', '16', '2015-09-07', '800000', '0', '800000')," +
            "(17, '2', '17', '2015-12-07', '1500000', '0', '1500000')," +
            "(18, '1', '18', '2015-12-02', '3000000', '0', '3000000')," +
            "(19, '1', '16', '2015-12-07', '200000', '0', '200000')," +
            "(20, '1', '1', '2015-12-05', '32193', '0', '32193');";
    private static final String INITIAL_LOAN_GIVEN_LIST = "INSERT INTO loan_given (loan_id, given_by, given_to, start_date, end_date, amount) VALUES" +
            "('1', '1', 'Imtiaz Karim', '2015-03-01', '2015-12-10', '10000')," +
            "('2', '1', 'Imtiaz Karim', '2015-12-01', '2015-12-04', '350')," +
            "('3', '1', 'Amina Rahman', '2015-07-06', '2015-10-06', '6450')," +
            "('4', '1', 'Amina Rahman', '2015-05-12', '2016-05-12', '10242')," +
            "('5', '1', 'Ibrahim Tahmid', '2015-12-06', '2015-12-31', '200')," +
            "('6', '1', 'Israt Zaman', '2015-11-28', '2015-12-21', '1212');";
    private static final String INITIAL_SAVINGS_CATEGORYL_LIST = "" +
            "INSERT INTO savings_category (savings_category_id, savings_category_name) VALUES" +
            "('1', 'Gift');";
    private static final String INITIAL_SAVINGS_LIST = "INSERT INTO savings (savings_id, savings_category_id, user_id, savings_amount, savings_description, savings_date) VALUES" +
            "('1', '1', '1', '10734', 'Hello', '2015-05-04')," +
            "('2', '1', '1', '345', 'nishas wallet', '2012-07-18')," +
            "('3', '1', '1', '9456', 'nishas wallet2', '2015-12-21');";
    private static final String INITIAL_ADMIN_LIST = "INSERT INTO admin (admin_user_name,admin_name,password) VALUES ('1','sultan','123'),('2','amina','123'),('3','israt','123')";
    private static final String INITIAL_TAX_CALCULATION_PARAMETERS_LIST = "" +
            "INSERT INTO tax_calculation_parameters (first_slot_if_freedom_fighter, first_slot_if_retired, first_slot_if_female, regular_first_slot, second_slot, third_slot, fourth_slot, fifth_slot, first_slot_multiplier, second_slot_multiplier, third_slot_multiplier, fourth_slot_multiplier, fifth_slot_multiplier, tax_lowest_highest_value, tax_lowest_second_highest_value, tax_lowest_lowest_value, year, tax_lowest_highest_place, tax_lowest_second_highest_place) VALUES ('425000', '375000', '300000', '250000', '400000', '500000', '600000', '3000000', '0.1', '0.15', '0.2', '0.25', '0.3', '5000', '4000', '3000', '2016', 'DHAKA+CHITTAGONG', 'RONGPUR+SYLHET+BARISAL+KHULNA+RAJSHAHI')";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized DatabaseHelper getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_ASSET_CATEGORY_TABLE);
        db.execSQL(CREATE_ASSET_TABLE);
        db.execSQL(CREATE_BANK_TABLE);
        db.execSQL(CREATE_BANK_LOAN);
        db.execSQL(CREATE_BANK_SAVINGS);
        db.execSQL(CREATE_EXPENDITURE_CATEGORIES);
        db.execSQL(CREATE_EXPENDITURE);
        db.execSQL(CREATE_INCOME_SOURCE_CATEGORY);
        db.execSQL(CREATE_INCOME);
        db.execSQL(CREATE_LOAN_GIVEN);
        db.execSQL(CREATE_SAVINGS_CATEGORY);
        db.execSQL(CREATE_SAVINGS);
        db.execSQL(CREATE_ADMIN);
        db.execSQL(CREATE_TAX_CALCULATION_PARAMETERS);


        db.execSQL(INITIAL_USER_LIST);
        db.execSQL(INITIAL_ASSET_CATEGORY_LIST);
        db.execSQL(INITIAL_ASSET_LIST);
        db.execSQL(INITIAL_BANK_LIST);
        db.execSQL(INITIAL_BANK_LOAN_LIST);
        db.execSQL(INITIAL_BANK_SAVINGS_LIST);
        db.execSQL(INITIAL_EXPENDITURE_CATEGORY_LIST);
        db.execSQL(INITIAL_EXPENDITURE_LIST);
        db.execSQL(INITIAL_INCOME_SOURCE_CATEGORY_LIST);
        db.execSQL(INITIAL_INCOME_LIST);
        db.execSQL(INITIAL_LOAN_GIVEN_LIST);
        db.execSQL(INITIAL_SAVINGS_CATEGORYL_LIST);
        db.execSQL(INITIAL_SAVINGS_LIST);
        db.execSQL(INITIAL_ADMIN_LIST);
        db.execSQL(INITIAL_TAX_CALCULATION_PARAMETERS_LIST);


    }

    public ArrayList<User> getUsersList() {
        UserHelper userHelper = new UserHelper();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        //SQLiteDatabase sqLiteReadableDatabase= this.getReadableDatabase();
        ArrayList<User> userArrayList = userHelper.getAllUsers(sqLiteDatabase);
        return userArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ASSET);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ASSET_CATEGORY);


        // create new tables
        onCreate(db);
    }

    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }


    public int getUserId(String userMail, String password) {
        int returnValue;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        UserHelper userHelper = new UserHelper();
//        Log.d("USer mail: ",userMail);
//        Log.d("Password: ",password);
        returnValue = userHelper.getUserId(userMail, password, sqLiteDatabase);


        return returnValue;
    }

    public ArrayList<Asset> getAllAssets(int userID) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<Asset> assetArrayList = new ArrayList<Asset>();
        AssetHelper assetHelper = new AssetHelper();
        assetArrayList = assetHelper.getAllAssets(sqLiteDatabase, userID);
        return assetArrayList;
    }

    public ArrayList<BankSavings> getAllBankSavings(int userId) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<BankSavings> bankSavingsArrayList = new ArrayList<>();
        BankSavingsHelper bankSavingsHelper = new BankSavingsHelper();
        bankSavingsArrayList = bankSavingsHelper.getAllBankSavings(sqLiteDatabase, userId);
        return bankSavingsArrayList;
    }

    public TaxReport getTaxReport(int userID) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        TaxHelper taxHelper = new TaxHelper();
        TaxReport taxReport = taxHelper.getTaxReport(sqLiteDatabase, userID);
        return taxReport;

    }

    ;

    public ArrayList<Borrow> getBorrowList(int userID) {
        BankLoanHelper bankLoanHelper = new BankLoanHelper();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<Borrow> borrowArrayList = bankLoanHelper.getBorrowArrayList(sqLiteDatabase, userID);

        return borrowArrayList;

    }

    public ArrayList<Loan> getLoansGivenList(int userID) {
        LoanGivenHelper loanGivenHelper = new LoanGivenHelper();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<Loan> loanArrayList = loanGivenHelper.getLoansGiven(sqLiteDatabase, userID);
        return loanArrayList;
    }

    public ArrayList<Income> getIncomeList(int userID) {
        IncomeHelper incomeHelper = new IncomeHelper();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<Income> incomeArrayList = incomeHelper.getIncome(sqLiteDatabase, userID);
        return incomeArrayList;
    }

    public ArrayList<Expenditure> getExpenditureList(int userID) {
        ExpenditureHelper expenditureHelper = new ExpenditureHelper();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<Expenditure> expenditureArrayList=expenditureHelper.getExpenditure(sqLiteDatabase,userID);
        return expenditureArrayList;
    }

    public ArrayList<Savings> getSavingsList(int userID){
        SavingsHelper savingsHelper= new SavingsHelper();
        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();
        ArrayList<Savings> savingsArrayList= savingsHelper.getSavings(sqLiteDatabase,userID);
        //Log.d("%%%%%", ""+savingsArrayList.size());
        return  savingsArrayList;
    }

    public void addAsset(int userID, Asset asset){
        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();
        String assetCategory=asset.getAssetCategory();
        String selectQuery1="select asset_category_id from asset_category where asset_category_name = '"+assetCategory+"'";
        Cursor c1=sqLiteDatabase.rawQuery(selectQuery1,null);
        int assetCategoryID=-1;
        if(c1.moveToFirst()){
            do{
                assetCategoryID=Integer.parseInt(c1.getString(0));
            }while(c1.moveToNext());
        }
        c1.close();
        Log.d("%%%%%%%%%%%",asset.toString());
        Log.d("%%%%%%%%%%%",""+assetCategoryID);

        //Asset asset,SQLiteDatabase sqLiteDatabase,int assetCategoryID, int userID

        AssetHelper assetHelper= new AssetHelper();
        SQLiteDatabase sqLiteDatabase1= this.getWritableDatabase();
        assetHelper.createNewAsset(asset,sqLiteDatabase1,assetCategoryID,userID);
        return;



    }
    public void addLoansGiven(int userID, Loan loan){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String selectQuery="select max(loan_id) from loan_given";
        Cursor cursor=sqLiteDatabase.rawQuery(selectQuery,null);

        int addLoansID=-1;
        if(cursor.moveToFirst()){
            do{
                addLoansID=Integer.parseInt(cursor.getString(0));
            }while(cursor.moveToNext());
        }
        cursor.close();

        SQLiteDatabase sqLiteDatabase1= this.getWritableDatabase();
        LoanGivenHelper loanGivenHelper= new LoanGivenHelper();
        loanGivenHelper.addLoansGiven(sqLiteDatabase1,userID,(addLoansID+1),loan);
        return;

    }

    public void addBankLoan(int userID, Borrow borrow){
        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();
        String selectQuery="select max(bank_loan_id) from bank_loan";
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery,null);
        int borrowID=-1;
        if(cursor.moveToFirst()){

            do{
                borrowID=Integer.parseInt(cursor.getString(0));
            }while(cursor.moveToNext());
        }
        cursor.close();

        int bankID=-1;
        String selectQuery2="select bank_id from bank where bank_name='"+borrow.getBankName()+"'";
        Cursor cursor1= sqLiteDatabase.rawQuery(selectQuery2,null);
        if(cursor1.moveToFirst()){
            do{
                bankID=Integer.parseInt(cursor1.getString(0));
            }while(cursor1.moveToNext());
        }
        cursor1.close();
        BankLoanHelper bankLoanHelper= new BankLoanHelper();
        SQLiteDatabase sqLiteDatabase1= this.getWritableDatabase();
        bankLoanHelper.addBankLoan(sqLiteDatabase1,userID,bankID,borrow,(borrowID+1));

        return;




    }

    public void addBankSavings(int userID, BankSavings bankSavings){

        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();
        //SQLiteDatabase sqLiteDatabase, int userID, BankSavings bankSavings, int bankID, int savingsID
        int bankID=-1;
        String selectQuery2="select bank_id from bank where bank_name='"+bankSavings.getBankName()+"'";
        Cursor cursor1= sqLiteDatabase.rawQuery(selectQuery2,null);
        if(cursor1.moveToFirst()){
            do{
                bankID=Integer.parseInt(cursor1.getString(0));
            }while(cursor1.moveToNext());
        }
        cursor1.close();

        int savingsID=-1;
        String selectQuery="select max(bank_savings_id) from bank_savings";
        Cursor cursor=sqLiteDatabase.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                savingsID=Integer.parseInt(cursor.getString(0));
            }while(cursor.moveToNext());
        }
        SQLiteDatabase sqLiteDatabase1= this.getWritableDatabase();
        BankSavingsHelper bankSavingsHelper= new BankSavingsHelper();
        bankSavingsHelper.addBankSavings(sqLiteDatabase1,userID,bankSavings,bankID,(savingsID+1));

        return;


    }
    public void addExpenditure(int userID, Expenditure expenditure){
        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();
        String selectQuery="select expenditure_category_id from expenditure_category where expenditure_category_name='"+expenditure.getExpenditureCategoryName()+"'";
        Cursor cursor= sqLiteDatabase.rawQuery(selectQuery,null);
        int expenditureCategoryID=-1;
        if(cursor.moveToFirst()){
            do{
                expenditureCategoryID=Integer.parseInt(cursor.getString(0));
            }while(cursor.moveToNext());
        }
       cursor.close();
//        sqLiteDatabase.close();
        //int userID, int expenditureCategoryID, Expenditure expenditure,SQLiteDatabase sqLiteDatabase
        Log.d("////////",""+expenditureCategoryID);
        Log.d("////////",""+userID);
        Log.d("////////",expenditure.toString());


        SQLiteDatabase sqLiteDatabase1 = this.getWritableDatabase();
        ExpenditureHelper expenditureHelper= new ExpenditureHelper();
        expenditureHelper.addExpenditure(userID,expenditureCategoryID,expenditure,sqLiteDatabase1);
        return;
    }

    public void addIncome(int userID,Income income){
        //int userID, int incomeCategoryID, Income income,SQLiteDatabase sqLiteDatabase
        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();
        String selectQuery="select income_source_category_id from income_source_category where income_source_category_name='"+income.getIncomeSource()+"'";
        Cursor cursor= sqLiteDatabase.rawQuery(selectQuery,null);
        int incomeSourceCategoryID=-1;
        if(cursor.moveToFirst()){
            do{
                incomeSourceCategoryID=Integer.parseInt(cursor.getString(0));
            }while(cursor.moveToNext());
        }
        SQLiteDatabase sqLiteDatabase1=this.getWritableDatabase();
        IncomeHelper incomeHelper= new IncomeHelper();
        incomeHelper.addIncome(userID,incomeSourceCategoryID,income,sqLiteDatabase1);
        return;
    }


}
