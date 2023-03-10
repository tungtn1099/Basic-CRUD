USE [master]
GO
/****** Object:  Database [BasicCRUD]    Script Date: 01/02/2023 14:23:45 ******/
CREATE DATABASE [BasicCRUD]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BasicCRUD', FILENAME = N'D:\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\BasicCRUD.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'BasicCRUD_log', FILENAME = N'D:\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\BasicCRUD_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [BasicCRUD] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BasicCRUD].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BasicCRUD] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BasicCRUD] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BasicCRUD] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BasicCRUD] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BasicCRUD] SET ARITHABORT OFF 
GO
ALTER DATABASE [BasicCRUD] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [BasicCRUD] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BasicCRUD] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BasicCRUD] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BasicCRUD] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BasicCRUD] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BasicCRUD] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BasicCRUD] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BasicCRUD] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BasicCRUD] SET  DISABLE_BROKER 
GO
ALTER DATABASE [BasicCRUD] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BasicCRUD] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BasicCRUD] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BasicCRUD] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BasicCRUD] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BasicCRUD] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BasicCRUD] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BasicCRUD] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [BasicCRUD] SET  MULTI_USER 
GO
ALTER DATABASE [BasicCRUD] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BasicCRUD] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BasicCRUD] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BasicCRUD] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [BasicCRUD] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [BasicCRUD] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [BasicCRUD] SET QUERY_STORE = ON
GO
ALTER DATABASE [BasicCRUD] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [BasicCRUD]
GO
/****** Object:  User [tungtn]    Script Date: 01/02/2023 14:23:45 ******/
CREATE USER [tungtn] WITHOUT LOGIN WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[Accounts]    Script Date: 01/02/2023 14:23:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Accounts](
	[id] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[admin] [bit] NOT NULL,
 CONSTRAINT [PK_Accounts] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Departments]    Script Date: 01/02/2023 14:23:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Departments](
	[deptId] [int] IDENTITY(1,1) NOT NULL,
	[deptName] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Departments] PRIMARY KEY CLUSTERED 
(
	[deptId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Students]    Script Date: 01/02/2023 14:23:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Students](
	[stuId] [int] IDENTITY(1,1) NOT NULL,
	[stuName] [varchar](50) NOT NULL,
	[gender] [bit] NOT NULL,
	[dob] [date] NOT NULL,
	[deptId] [int] NOT NULL,
 CONSTRAINT [PK_Students] PRIMARY KEY CLUSTERED 
(
	[stuId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Students]  WITH CHECK ADD  CONSTRAINT [FK_Students_Departments] FOREIGN KEY([deptId])
REFERENCES [dbo].[Departments] ([deptId])
GO
ALTER TABLE [dbo].[Students] CHECK CONSTRAINT [FK_Students_Departments]
GO
USE [master]
GO
ALTER DATABASE [BasicCRUD] SET  READ_WRITE 
GO
