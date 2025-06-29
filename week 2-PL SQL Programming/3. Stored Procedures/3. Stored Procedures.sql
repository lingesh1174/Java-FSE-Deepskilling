--Scenario 1: ProcessMonthlyInterest
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
  FOR acc IN (
    SELECT AccountID, Balance
    FROM Accounts
    WHERE AccountType = 'Savings'
  ) LOOP
    UPDATE Accounts
    SET Balance = Balance + (acc.Balance * 0.01),
        LastModified = SYSDATE
    WHERE AccountID = acc.AccountID;
  END LOOP;

  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error processing interest: ' || SQLERRM);
    ROLLBACK;
END;



EXEC processmonthlyinterest;
SELECT AccountID, Balance FROM Accounts;


--Scenario 2: UpdateEmployeeBonus
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  p_Department IN VARCHAR2,
  p_BonusPercent IN NUMBER
) AS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * p_BonusPercent / 100)
  WHERE Department = p_Department;

  IF SQL%ROWCOUNT = 0 THEN
    DBMS_OUTPUT.PUT_LINE('No employees found in department: ' || p_Department);
  ELSE
    DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' employees updated in ' || p_Department);
  END IF;

  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error updating bonus: ' || SQLERRM);
    ROLLBACK;
END;


EXEC UpdateEmployeeBonus('IT', 10);
SELECT * FROM Employees WHERE Department = 'IT';


--Scenario 3: TransferFunds
CREATE OR REPLACE PROCEDURE TransferFunds (
  p_FromAccountID IN NUMBER,
  p_ToAccountID IN NUMBER,
  p_Amount IN NUMBER
) AS
  v_FromBalance NUMBER;
BEGIN
  SELECT Balance INTO v_FromBalance
  FROM Accounts
  WHERE AccountID = p_FromAccountID
  FOR UPDATE;

  IF v_FromBalance < p_Amount THEN
    DBMS_OUTPUT.PUT_LINE('Transfer aborted: Insufficient funds.');
    ROLLBACK;
    RETURN;
  END IF;

  UPDATE Accounts SET Balance = Balance - p_Amount
  WHERE AccountID = p_FromAccountID;

  UPDATE Accounts SET Balance = Balance + p_Amount
  WHERE AccountID = p_ToAccountID;

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Transfer successful: ' || p_Amount || ' transferred.');
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('Error: One of the account IDs is invalid.');
    ROLLBACK;
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
    ROLLBACK;
END;


EXEC TransferFunds(1, 2, 500); 
EXEC TransferFunds(2, 4, 999999);
SELECT * FROM customers;