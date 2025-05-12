CREATE TABLE CANHAN (
    Iden VARCHAR(10),
    UserName VARCHAR(10),
    MatKhau VARCHAR(10),
    HoTen NVARCHAR2(50),
    Email VARCHAR(50),
    Tuoi INTEGER,
    KhuVucSong NVARCHAR2(20),
    TienSuBenhLy NVARCHAR2(2000)
);

CREATE TABLE HOSOTHUOC (
    Iden_HST VARCHAR(10),
    NgayLap DATE,
    Iden VARCHAR(10),
    DuongDanDanhSachThuoc VARCHAR(200),
    FOREIGN KEY (Iden) REFERENCES CANHAN(Iden)
);
