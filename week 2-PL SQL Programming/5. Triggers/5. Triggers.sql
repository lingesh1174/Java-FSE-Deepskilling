--Scenario 1: UpdateCustomerLastModified
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
  :NEW.LastModified := SYSDATE;
END;


UPDATE Customers SET Balance = Balance + 100 WHERE CustomerID = 1;
SELECT LastModified FROM Customers WHERE CustomerID = 1;


--Scenario 2: LogTransaction
CREATE TABLE AuditLog (
  LogID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  TransactionID NUMBER,
  AccountID NUMBER,
  Action VARCHAR2(20),
  LogDate DATE DEFAULT SYSDATE
);


CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
  INSERT INTO AuditLog (TransactionID, AccountID, Action)
  VALUES (:NEW.TransactionID, :NEW.AccountID, 'INSERT');
END;


INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (5, 1, SYSDATE, 200, 'Deposit');

SELECT * FROM AuditLog;


--Scenario 3: CheckTransactionRules
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
  v_AccountBalance NUMBER;
BEGIN
  SELECT Balance INTO v_AccountBalance FROM Accounts WHERE AccountID = :NEW.AccountID;
  IF :NEW.TransactionType = 'Withdrawal' THEN
    IF :NEW.Amount > v_AccountBalance THEN
      RAISE_APPLICATION_ERROR(-20001, 'Withdrawal exceeds account balance.');
    END IF;
  ELSIF :NEW.TransactionType = 'Deposit' THEN
    IF :NEW.Amount <= 0 THEN
      RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
    END IF;
  END IF;
END;


-- Should succeed
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (6, 1, SYSDATE, 50, 'Deposit');

-- Should fail (invalid deposit)
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (7, 1, SYSDATE, 0, 'Deposit');

-- Should fail (withdrawal exceeds balance)
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (8, 1, SYSDATE, 999999, 'Withdrawal');

