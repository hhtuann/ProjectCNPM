# 🚀 HỆ THỐNG QUẢN LÝ TRUNG TÂM CUNG CẤP NHÂN CÔNG
### *Module Ký Hợp Đồng Với Khách Hàng*

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk">
  <img src="https://img.shields.io/badge/Java_Swing-Desktop_UI-blue?style=for-the-badge">
  <img src="https://img.shields.io/badge/MySQL-Database-00758F?style=for-the-badge&logo=mysql">
  <img src="https://img.shields.io/badge/JDBC-Connector-success?style=for-the-badge">
  <img src="https://img.shields.io/badge/NetBeans-IDE-1B6AC6?style=for-the-badge&logo=apache-netbeans-ide">
</p>

---

# 📌 Giới thiệu

Đây là dự án môn học được xây dựng nhằm mô phỏng và quản lý hoạt động của một **trung tâm cung cấp nhân công**, phát triển bằng **Java Swing** kết hợp với **MySQL**.

Repository này tập trung vào module:

> ✍️ **Ký hợp đồng với khách hàng**

Cho phép nhân viên kinh doanh thực hiện quy trình tạo hợp đồng, lựa chọn đầu việc, ca làm và xác nhận hợp đồng một cách trực quan, nhanh chóng và thuận tiện.

---

# ✨ Chức năng nổi bật

## 🔐 Đăng nhập hệ thống
- Xác thực tài khoản nhân viên
- Phân quyền theo vai trò người dùng

## 📄 Quản lý hợp đồng
- Tìm kiếm và chọn khách hàng
- Tạo hợp đồng cung cấp nhân công
- Thêm đầu việc / ca làm vào hợp đồng
- Chọn hình thức thanh toán
- Kiểm tra thông tin trước khi xác nhận
- Lưu hợp đồng vào cơ sở dữ liệu
- Xóa hoặc chỉnh sửa đầu việc đã chọn

---

# 🛠 Công nghệ sử dụng

| Công nghệ | Vai trò |
|---|---|
| Java | Ngôn ngữ lập trình chính |
| Java Swing | Xây dựng giao diện Desktop |
| MySQL | Hệ quản trị cơ sở dữ liệu |
| JDBC | Kết nối Java với MySQL |
| NetBeans | IDE phát triển |
| JUnit | Kiểm thử chương trình |

---

# 📚 Thư viện sử dụng

```txt
mysql-connector-java-8.0.30
junit-4.13.2
hamcrest-core-1.3
protobuf-java-3.19.4
```

---

# ⚙️ Yêu cầu môi trường

- ☕ JDK 21
- 🛢 MySQL Server
- 🧠 NetBeans IDE
- 🗄 Database: `db_labor_contract`

---

# 🧩 Cấu trúc thư mục

```bash
ProjectCNPM/
│
├── src/
│   ├── Main.java              # Điểm khởi chạy chương trình
│   ├── dao/                   # Tầng truy xuất dữ liệu
│   ├── model/                 # Các lớp mô hình dữ liệu
│   └── view/                  # Giao diện Java Swing
│
├── resources/
│   └── database/              # File SQL & dữ liệu mẫu
│
├── lib/                       # Thư viện ngoài
│
└── nbproject/                 # Cấu hình NetBeans
```

---

# 🚀 Hướng dẫn chạy dự án

## 1️⃣ Chuẩn bị cơ sở dữ liệu

Tạo database trong MySQL:

```sql
db_labor_contract
```

Sau đó chạy toàn bộ file SQL trong thư mục:

```bash
resources/database/
```

---

## 2️⃣ Cấu hình kết nối CSDL

Mở file:

```bash
src/dao/DAO.java
```

Kiểm tra và cập nhật thông tin kết nối:

```java
jdbc:mysql://localhost:3306/db_labor_contract?useUnicode=true&characterEncoding=UTF-8
```

```txt
Username: root
Password: 216556
```

> ⚠️ Hãy kiểm tra và chỉnh sửa lại tài khoản/mật khẩu trước khi chạy chương trình.

---

## 3️⃣ Chạy chương trình

- Mở project bằng **NetBeans**
- Add toàn bộ file `.jar` trong thư mục `lib/`
- Chạy file:

```bash
Main.java
```

---

# 🖥 Luồng hoạt động hệ thống

```text
Đăng nhập
   ↓
Chọn khách hàng
   ↓
Tạo hợp đồng
   ↓
Chọn đầu việc
   ↓
Thêm ca làm
   ↓
Xác nhận hợp đồng
   ↓
Lưu vào cơ sở dữ liệu
```

---

# 📌 Ghi chú

- Màn hình khởi động hệ thống: `LoginFrm`
- Người dùng chỉ được truy cập chức năng phù hợp với vai trò
- Có thể thay đổi dữ liệu mẫu hoặc luồng nghiệp vụ theo yêu cầu môn học

---

# 👨‍💻 Thông tin môn học

📚 **Học phần:** Nhập môn Công nghệ Phần mềm  
🏫 **Học viện Công nghệ Bưu chính Viễn thông (PTIT)**  
👨‍🏫 **Giảng viên hướng dẫn:** PGS.TS. Nguyễn Mạnh Hùng

---