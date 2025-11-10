# Spidy – The Web Crawler

> A high-performance, multithreaded web crawler built in Java that automatically explores and extracts hyperlinks from web pages up to a defined depth — featuring thread-safe data handling, concurrency control, and modular design.

[Screencast from 2025-11-10 08-11-12.webm](https://github.com/user-attachments/assets/c209751f-69ca-438d-9af9-7bade21c0ede)

## Overview

Spidy is a multithreaded web crawler designed to efficiently traverse websites, extract links, and manage concurrent crawling tasks.  
It leverages Java Concurrency APIs (ExecutorService, Phaser, ConcurrentHashMap, BlockingQueue) and Jsoup for HTML parsing to achieve scalable and thread-safe web crawling.

## Features

- Automatic Link Discovery: Fetches and extracts hyperlinks from any given starting URL.  
- Multithreaded Execution: Runs multiple crawl tasks concurrently for improved performance.  
- Thread-Safe Architecture: Uses ConcurrentHashMap and BlockingQueue to prevent duplicate processing and ensure safe parallelism.  
- Depth-Limited Traversal: Crawls only up to a specified depth to prevent infinite recursion.  
- Modular Design: Independent modules for URL management, fetching, and crawling logic.  
- Extensible Framework: Easily add content filters, data storage, or analytics modules.

## Architecture

WebCrawler (Main Entry Point)
- Initializes threads
- Starts crawl tasks

CrawlerTask
- Fetches URLs
- Extracts links
- Submits new tasks

URLFetcher
- Parses HTML using Jsoup
- Returns all hyperlinks

URLStore
- Manages visited URLs
- Stores unvisited queue

## Tech Stack

- Language: Java  
- Libraries: Jsoup (HTML Parsing), Java Concurrency APIs  
- Concepts Used: Multithreading, Synchronization, Concurrency Control, Data Structures  

## How It Works

1. User provides a starting URL and a maximum crawl depth.  
2. The crawler:
   - Fetches the HTML content using Jsoup  
   - Extracts all hyperlinks (<a href="">)  
   - Adds new URLs to a BlockingQueue if not already visited  
3. Threads run concurrently using ExecutorService, synchronized with Phaser.  
4. Crawling stops once the defined depth is reached.  

## Setup & Usage

### Prerequisites
- Java 17+  
- Maven or Gradle  
- Internet connection for crawling  

### Steps
```bash
# Clone this repository
git clone https://github.com/<DevKartikBhardwaj/Spidy---The-Web-Crawler.git
cd Spidy---The-Web-Crawler/

# Compile and run
mvn compile
mvn exec:java -Dexec.mainClass="org.example.WebCrawler"
```

Then enter the URL and desired crawl depth when prompted.

## Sample Output

Enter your URL: https://example.com  
Enter crawl depth: 2  

[INFO] Crawling: https://example.com  
[INFO] Found: https://example.com/about  
[INFO] Found: https://example.com/contact  
[INFO] Crawling completed. Total links visited: 123  

## Future Enhancements

- Add support for asynchronous crawling (CompletableFuture)
- Include page content indexing (for search engine applications)
- Add filters (domain-based, content-type)
- Store results in a database or file
- Visualize link graphs using GraphStream or Neo4j

## Contributing

Contributions are welcome!  
Feel free to fork this repo and submit a pull request to enhance functionality or documentation.

## License

This project is licensed under the MIT License – see the LICENSE file for details.

## Author

Kartik Bhardwaj  
Email: [kartikbhardwaj.coer@gmail.com]  
GitHub: [https://github.com/DevKartikBhardwaj]
