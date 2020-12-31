package com.webtutsplus.ecommerce.model;

public class FileInfo {
  private String name;
  private String url;

  /**
   * Constructor for FileInfo object.
   * @param name
   * @param url
   */
  public FileInfo(String name, String url) {
    this.name = name;
    this.url = url;
  }

  /**
   * Used to get the name of the file.
   * @return name of type String.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Used to set the name of the file.
   * @param name the new name of the file.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Used to get the the URL of the file.
   * @return url of type String.
   */
  public String getUrl() {
    return this.url;
  }

  /**
   * Used to set the URL of the file.
   * @param url the new URL of the file.
   */
  public void setUrl(String url) {
    this.url = url;
  }
}
