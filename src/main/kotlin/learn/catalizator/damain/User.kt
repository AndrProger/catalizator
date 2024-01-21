package learn.catalizator.damain

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.Data
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Table("usr")
@Data
 class User(
	@Id
	 val id: Long? = null,
	@get:JvmName("getUserNameField") // Use @JvmName to avoid the clash
	val username: String? = null,
	@JsonIgnore
	@get:JvmName("getPasswordField") // Use @JvmName to avoid the clash
	val password: String? = null,
	val role:UserRole?=null

) :UserDetails{
	override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
		return mutableListOf(SimpleGrantedAuthority(role!!.name))
	}

	override fun getPassword(): String {
		return password!!
	}


	override fun getUsername(): String {
		return  username!!
	}

	override fun isAccountNonExpired(): Boolean {
		return true
	}

	override fun isAccountNonLocked(): Boolean {
		return true
	}

	override fun isCredentialsNonExpired(): Boolean {
		return true
	}

	override fun isEnabled(): Boolean {
		return true
	}

}