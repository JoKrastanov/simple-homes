import React from "react";

import "../StyleSheets/Profile.css";

const Profile = () => {
    return (
      <div className={"profile"}>
          <div className={"profile-info"}>
              Profile Data
          </div>
        <div className={"bookmarked-properties"}>
            Bookmarks
        </div>
      </div>
    );
}

export default Profile