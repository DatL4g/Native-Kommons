package dev.datlag.kommons


data object Ecuador : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("EC")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("ECU")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(218)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(593)
}