--Scenario 1: CalculateAge
CREATE OR REPLACE FUNCTION CalculateAge (
    p_DOB IN DATE
) RETURN NUMBER IS
    v_Age NUMBER;
BEGIN
    v_Age := FLOOR(MONTHS_BETWEEN(SYSDATE, p_DOB) / 12);
    RETURN v_Age;
END;


SELECT Name, CalculateAge(DOB) AS Age FROM Customers;


--Scenario 2: CalculateMonthlyInstallment
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_LoanAmount IN NUMBER,
    p_AnnualInterestRate IN NUMBER,
    p_LoanYears IN NUMBER
) RETURN NUMBER IS
    v_Rate NUMBER;
    v_N NUMBER;
    v_EMI NUMBER;
BEGIN
    v_Rate := p_AnnualInterestRate / (12 * 100); -- monthly rate
    v_N := p_LoanYears * 12;
    IF v_Rate = 0 THEN
        v_EMI := p_LoanAmount / v_N;
    ELSE
        v_EMI := p_LoanAmount * v_Rate * POWER(1 + v_Rate, v_N) /
                 (POWER(1 + v_Rate, v_N) - 1);
    END IF;
    RETURN ROUND(v_EMI, 2);
END;


SELECT LoanID, CustomerID, CalculateMonthlyInstallment(LoanAmount, InterestRate, ROUND(MONTHS_BETWEEN(EndDate, StartDate) / 12)) AS EMI FROM Loans;


-- Scenario 3: HasSufficientBalance
CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_AccountID IN NUMBER,
    p_Amount IN NUMBER
) RETURN NUMBER IS
    v_Balance NUMBER;
BEGIN
    SELECT Balance INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_AccountID;
    IF v_Balance >= p_Amount THEN
        RETURN 1;
    ELSE
        RETURN 0;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
    WHEN OTHERS THEN
        RETURN 0;
END;


SELECT HasSufficientBalance(1, 500) AS IsSufficient FROM dual;