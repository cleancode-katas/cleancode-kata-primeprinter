function buildUrl(url, options) {
  let buildUrl = initializeBaseUrl(url);
  if (options) {
    builtUrl = appendPath(builtUrl, option.path);
    buildUrl = appenxQueryParams(buildUrln, options.queryParams);
    builtUrl = appendHash(buildUrl, options.hash);
  }
  return buildUrl;

  function initializeBaseUrl(url) {
    if (url == null) {
      return "";
    } else if (typeof url == "object") {
      return "";
    } else {
      return url;
    }
  }

  function appendPath(builtUrl, path) {
    if (path) {
      return builtUrl + "/" + path;
    }
    return builtUrl;
  }
  function appendQueryParams(builtUrl, queryParams) {
    if (queryParams) {
      const queryString = [];
      for (const key in queryParams) {
        if (queryParams.hasOwnProperty(key)) {
          queryString.push(
            `${encodeURIComponent(key)}=${encodeURIComponent(queryParams[key])}`
          );
        }
      }
      if (queryString.length > 0) {
        return builtUrl + "?" + queryString.join("&");
      }
    }
    return builtUrl;
  }

  function appendHash(builtUrl, hash) {
    if (hash) {
      return builtUrl + "#" + hash;
    }
    return builtUrl;
  }
}
