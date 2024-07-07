## WSD Ecom Project with Spring TDD Example

Server : Apache Tomcat
IDE : Eclipse
Spring Version :3.2.2
JDK : 17
DataBase : MySQL
Docker : 27.0.3

# Build application by following command

mvn clean install

# Docker 

docker-compose up -d

# For Log Monitoring Greylog 

docker-compose -f docker-compose-graylog.yml -p graylog_demo up -d


# Actuator

http://localhost:8080/actuator

# Here have five api endpoint with response

1.An API to return the wish list of a customer.

API endpoint : http://localhost:8080/api/customer/wishlist/tanzir206
API Response :
{
    "customerName": "Tanzil Ahamed",
    "userName": "tanzir206",
    "product": [
        {
            "id": 1,
            "productName": "Salt",
            "code": "salt-500",
            "unitPrice": 20.0,
            "totalStock": 20
        },
        {
            "id": 2,
            "productName": "ToothPaste",
            "code": "tp",
            "unitPrice": 100.0,
            "totalStock": 100
        }
    ]
}

2.An API to return the total sale amount of the current day.

API endpoint : http://localhost:8080/api/product/sale/currentdate

API Response :

totalSale:1340.0

3.An API to return the max sale day of a certain time range.

API endpoint : http://localhost:8080/api/product/sale/daterange?startDate=2024-06-01&endDate=2024-06-30

API Response :

{
    "id": 4,
    "product": {
        "id": 5,
        "productName": "Beef",
        "code": "bf",
        "unitPrice": 700.0,
        "totalStock": 700
    },
    "totalAmount": 1.0,
    "totalPrice": 700.0,
    "saleDate": "2024-06-09"
}

4.An API to return top 5 selling items of all time (based on total sale amount).

API endpoint : http://localhost:8080/api/product/sale/alltime

API Response :
[
    {
        "id": 8,
        "product": {
            "id": 3,
            "productName": "Chawl",
            "code": "ch",
            "unitPrice": 60.0,
            "totalStock": 60
        },
        "totalAmount": 5.0,
        "totalPrice": 300.0,
        "saleDate": "2024-06-12"
    },
    {
        "id": 4,
        "product": {
            "id": 5,
            "productName": "Beef",
            "code": "bf",
            "unitPrice": 700.0,
            "totalStock": 700
        },
        "totalAmount": 1.0,
        "totalPrice": 700.0,
        "saleDate": "2024-06-09"
    },
    {
        "id": 6,
        "product": {
            "id": 4,
            "productName": "Fish",
            "code": "fh",
            "unitPrice": 200.0,
            "totalStock": 200
        },
        "totalAmount": 3.0,
        "totalPrice": 600.0,
        "saleDate": "2024-06-11"
    },
    {
        "id": 3,
        "product": {
            "id": 2,
            "productName": "ToothPaste",
            "code": "tp",
            "unitPrice": 100.0,
            "totalStock": 100
        },
        "totalAmount": 1.0,
        "totalPrice": 100.0,
        "saleDate": "2024-06-22"
    },
    {
        "id": 7,
        "product": {
            "id": 6,
            "productName": "Biscuit",
            "code": "bs",
            "unitPrice": 50.0,
            "totalStock": 50
        },
        "totalAmount": 2.0,
        "totalPrice": 100.0,
        "saleDate": "2024-07-05"
    }
]

5.An API to return top 5 selling items of the last month (based on number of sales).

API Endpoint : http://localhost:8080/api/product/sale/lastMonth

API Response :

[
    {
        "id": 8,
        "product": {
            "id": 3,
            "productName": "Chawl",
            "code": "ch",
            "unitPrice": 60.0,
            "totalStock": 60
        },
        "totalAmount": 5.0,
        "totalPrice": 300.0,
        "saleDate": "2024-06-12"
    },
    {
        "id": 6,
        "product": {
            "id": 4,
            "productName": "Fish",
            "code": "fh",
            "unitPrice": 200.0,
            "totalStock": 200
        },
        "totalAmount": 3.0,
        "totalPrice": 600.0,
        "saleDate": "2024-06-11"
    },
    {
        "id": 1,
        "product": {
            "id": 1,
            "productName": "Salt",
            "code": "salt-500",
            "unitPrice": 20.0,
            "totalStock": 20
        },
        "totalAmount": 1.0,
        "totalPrice": 20.0,
        "saleDate": "2024-06-29"
    },
    {
        "id": 4,
        "product": {
            "id": 5,
            "productName": "Beef",
            "code": "bf",
            "unitPrice": 700.0,
            "totalStock": 700
        },
        "totalAmount": 1.0,
        "totalPrice": 700.0,
        "saleDate": "2024-06-09"
    },
    {
        "id": 3,
        "product": {
            "id": 2,
            "productName": "ToothPaste",
            "code": "tp",
            "unitPrice": 100.0,
            "totalStock": 100
        },
        "totalAmount": 1.0,
        "totalPrice": 100.0,
        "saleDate": "2024-06-22"
    }
]