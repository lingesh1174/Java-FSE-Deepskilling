--Scenario 1: GenerateMonthlyStatements
DECLARE
  CURSOR txn_cursor IS
    SELECT c.CustomerID, c.Name, t.TransactionID, t.TransactionDate, t.Amount, t.TransactionType
    FROM Customers c
    JOIN Accounts a ON c.CustomerID = a.CustomerID
    JOIN Transactions t ON a.AccountID = t.AccountID
    WHERE TRUNC(t.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM')
    ORDER BY c.CustomerID, t.TransactionDate;
    
  v_Name Customers.Name%TYPE;
  v_CustID Customers.CustomerID%TYPE;
  v_TxnID Transactions.TransactionID%TYPE;
  v_Date Transactions.TransactionDate%TYPE;
  v_Amt Transactions.Amount%TYPE;
  v_Type Transactions.TransactionType%TYPE;
BEGIN
  DBMS_OUTPUT.PUT_LINE('--- Monthly Statement ---');
  FOR txn IN txn_cursor LOOP
    DBMS_OUTPUT.PUT_LINE('Customer: ' || txn.Name || 
                         ' | Txn ID: ' || txn.TransactionID ||
                         ' | Date: ' || TO_CHAR(txn.TransactionDate, 'DD-MON') ||
                         ' | ' || txn.TransactionType ||
                         ' | Amount: $' || txn.Amount);
  END LOOP;
END;



--Scenario 2: ApplyAnnualFee
DECLARE
  CURSOR acc_cursor IS
    SELECT AccountID, Balance
    FROM Accounts;

  v_AccountID Accounts.AccountID%TYPE;
  v_Balance Accounts.Balance%TYPE;
  v_Fee CONSTANT NUMBER := 500;
BEGIN
  FOR acc IN acc_cursor LOOP
    IF acc.Balance >= v_Fee THEN
      UPDATE Accounts
      SET Balance = Balance - v_Fee, LastModified = SYSDATE WHERE AccountID = acc.AccountID;
    ELSE
      DBMS_OUTPUT.PUT_LINE('Skipping Account ' || acc.AccountID || ': Insufficient balance for annual fee.');
    END IF;
  END LOOP;
  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Annual fees applied.');
END;



--Scenario 3: UpdateLoanInterestRates
DECLARE
  CURSOR loan_cursor IS
    SELECT LoanID, LoanAmount, InterestRate FROM Loans;

  v_LoanID Loans.LoanID%TYPE;
  v_Amount Loans.LoanAmount%TYPE;
  v_Rate Loans.InterestRate%TYPE;
BEGIN
  FOR loan IN loan_cursor LOOP
    IF loan.LoanAmount > 10000 THEN
      UPDATE Loans
      SET InterestRate = InterestRate + 1 WHERE LoanID = loan.LoanID;
    ELSIF loan.LoanAmount < 5000 THEN
      UPDATE Loans
      SET InterestRate = InterestRate - 0.5 WHERE LoanID = loan.LoanID;
    END IF;
  END LOOP;
  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Loan interest rates updated as per policy.');
END;


